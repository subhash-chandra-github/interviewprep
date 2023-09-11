package com.interviewprep.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Delphix {

    private static final String arrivalAirportUrl = "https://opensky-network.org/api/flights/arrival";


    static class TimeGap{

        private long hours;
        private long minutes;
        private long seconds;

        public long getHours() {
            return hours;
        }

        public void setHours(long hours) {
            this.hours = hours;
        }

        public long getMinutes() {
            return minutes;
        }

        public void setMinutes(long minutes) {
            this.minutes = minutes;
        }

        public long getSeconds() {
            return seconds;
        }

        public void setSeconds(long seconds) {
            this.seconds = seconds;
        }

        @Override
        public String toString() {
            return "  FlightDurationMaxTimeGap : "  + hours + " hours, " + minutes +" minutes, "+seconds+ " seconds";
        }
    }

    static class Result {
        private String airportCode;
        private long duration;

        public String getAirportCode() {
            return airportCode;
        }

        public void setAirportCode(String airportCode) {
            this.airportCode = airportCode;
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }
    }


    static class FlightDetails {
        private String estDepartureAirport;
        private long firstSeen;
        private long lastSeen;
        private long duration;

        public String getEstDepartureAirport() {
            return estDepartureAirport;
        }

        public void setEstDepartureAirport(String estDepartureAirport) {
            this.estDepartureAirport = estDepartureAirport;
        }

        public long getFirstSeen() {
            return firstSeen;
        }

        public void setFirstSeen(long firstSeen) {
            this.firstSeen = firstSeen;
        }

        public long getLastSeen() {
            return lastSeen;
        }

        public void setLastSeen(long lastSeen) {
            this.lastSeen = lastSeen;
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }
    }


    static class RestResponse<T> {

        private int status;
        private T data;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {

        System.out.println("Starting Application");
        List<FlightDetails> flightDetails = getFlightDetails(1615226604, 1615485804, "KSFO");
        Map<String, List<FlightDetails>> flightDetailMap = flightDetails.stream().filter(e -> Objects.nonNull(e.getEstDepartureAirport()))
                .collect(Collectors.groupingBy(FlightDetails::getEstDepartureAirport));
        //Creating map of departure airport code and flight details after removing null airpot code
        List<Result> results = processFlightDetails(flightDetailMap);
        System.out.println("Printing result :");
        System.out.println("");
        printResult(results,5);

    }

    private static void printResult(List<Result> results, int size) {
        if(size>results.size()){
            size = results.size();
        }
        for (int i = 0; i < size; i++) {
            long duration = results.get(i).getDuration();
            TimeGap timeGap = getTimeGap(duration);
            System.out.print("AirportCode: " + results.get(i).getAirportCode() + timeGap );
            System.out.println();
        }
    }

    private static TimeGap getTimeGap(long duration){
        TimeGap timeGap = new TimeGap();
        long hour = duration / (60 * 60);
        duration = duration - (60 * 60) * hour;
        long minutes = duration / 60;
        duration = duration - 60 * minutes;
        timeGap.setHours(hour);
        timeGap.setMinutes(minutes);
        timeGap.setSeconds(duration);
        return timeGap;

    }

    private static List<Result> processFlightDetails(Map<String, List<FlightDetails>> flightDetailMap) {
        List<Result> results = new ArrayList<>();
        for (Map.Entry<String, List<FlightDetails>> entry : flightDetailMap.entrySet()) {

            String airportCode = entry.getKey();
            List<FlightDetails> flightDetailsForAirport = entry.getValue();

            FlightDetails minDuration = flightDetailsForAirport.get(0);
            FlightDetails maxDuration = flightDetailsForAirport.get(0);
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (FlightDetails f : flightDetailsForAirport) { //finding minium and maximum duration flight
                if (min > f.getDuration()) {
                    min = f.getDuration();
                    minDuration = f;
                }
                if (max < f.getDuration()) {
                    max = f.getDuration();
                    maxDuration = f;
                }

            }
            Result result = new Result();
            result.setAirportCode(airportCode);
            result.setDuration(maxDuration.getDuration() - minDuration.getDuration());
            results.add(result);
        }
        results.sort(Comparator.comparing(Result::getDuration).reversed());
        return results;
    }

    private static List<FlightDetails> getFlightDetails(long startTime, long endTime, String airportCode) {
        List<FlightDetails> flightDetails = new ArrayList<>();
        String url = arrivalAirportUrl + "?airport=" + airportCode + "&begin=" + startTime + "&end=" + endTime;
        RestResponse<String> response = callExternalAPI(url,3);//retry 3 times if api call fails
        if (response.getStatus() == 200) {
            String data = response.getData();
            try {
                Object object = null;
                JSONArray arrayObj = null;
                JSONParser jsonParser = new JSONParser();
                object = jsonParser.parse(data);
                arrayObj = (JSONArray) object;
                for (Object o : arrayObj) {
                    FlightDetails f = new FlightDetails();
                    long lastSeen = (long) ((JSONObject) o).get("lastSeen");
                    long firstSeen = (long) ((JSONObject) o).get("firstSeen");
                    String departureAirport = (String) ((JSONObject) o).get("estDepartureAirport");
                    f.setLastSeen(lastSeen);
                    f.setFirstSeen(firstSeen);
                    f.setEstDepartureAirport(departureAirport);
                    f.setDuration(lastSeen - firstSeen);
                    flightDetails.add(f);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return flightDetails;
    }


    private static RestResponse<String> callExternalAPI(String apiUrl, int retryCount) {
        RestResponse<String> restResponse = new RestResponse<>();
        try {
            System.out.println("Calling open-sky api");
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            restResponse.setStatus(con.getResponseCode());
            if(con.getResponseCode()!=200 && retryCount>0){
                return callExternalAPI(apiUrl, retryCount-1);
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            restResponse.setData(content.toString());
            System.out.println("Response received from api");
        } catch (IOException mex) {
            mex.printStackTrace();
            restResponse.setStatus(500);
            System.out.println("Error while reading the response from the api");
        }
        return  restResponse;

    }

// ===== Preface =====

// This question is very difficult in C and C++, where there is
// insufficient library support to answer it in an hour. If you
// prefer to program in one of those languages, please ask us to
// provide you with a question designed for those languages instead!


// ===== Intro =====

// San Francisco's International Airport (SFO) continuously tries
// to improve the quality of its flight estimates by analyzing data
// from past flights and figuring out the root-cause of outliers
// and inaccurate estimates. In order to do this the teams that are
// tasked to solve this problem need to figure out ways of finding
// those outliers in their data.

// For the purpose of this interview question, imagine that you are
// one of the engineers working on this problem. One of your colleagues
// suggested during a meeting that a good first step on finding those
// outliers would be categorize past flight information by departure
// airport (e.g. the airport that a plane departs from to arrive at SFO)
// and focus on the ones whose flight duration varies the most. Your team
// decided that this idea is worth pursuing and you're tasked with
// implementing it.

// Your goal is to write a small program that utilizes the OpenSky
// public API and prints the 5 most varied flight duration data
// from flights that arrived in SFO the past 3 days, categorized by
// departure airport.

// Here is an example of the output of such a utility:

//     ---------------------------------------------------
//     Interval [2021-03-08 18:03:24, 2021-03-11 18:03:24]
//     ---------------------------------------------------
//     Airport Code | (max - min flight duration)
//     ---------------------------------------------------
//     LFPG         | 23:27:18
//     KORD         | 5:20:06
//     KDEN         | 4:16:37
//     VIDP         | 1:03:25
//     KEWR         | 0:44:26


// Interpreting the above data we can see that in the past 3 days
// we saw a big outlier in which the slowest flight from LFPG
// (Charles de Gaulle in Paris) was more than 23 hours slower than
// the quickest flight from that same airport.

// Rules/constraints:
// * Print the 5 departure airports in sorted order (the airport
//   with the maximum flight difference should appear at the top
//   and the rest shall follow in descending order).
// * Limit the output to 5 departure airports
// * Print actual difference in time between the longest and the
//   shortest flight duration.

// Your output does not need to match the above example, The example
// mostly exists to explain the problem and act as a guide to what
// what we are looking for. If you have better ideas of how to display
// the data, please do!

// You should implement this in whatever language you're most
// comfortable with -- just make sure your code is production
// quality, well designed, and easy to read.

// Finally, please help us by keeping this question and your
// answer secret so that every candidate has a fair chance in
// future Delphix interviews.


// ===== Steps =====

// 1.  Choose the language you want to code in from the menu
//     labeled "Plain Text" in the top right corner of the
//     screen. You will see a "Run" button appear on the top
//     left -- clicking this will send your code to a Linux
//     server and compile / run it. Output will appear on the
//     right side of the screen.

//     For information about what libraries are available for
//     your chosen language, see:

//       https://coderpad.io/languages

// 2.  Pull up the documentation for the API you'll be using:

//       https://opensky-network.org/apidoc/rest.html

// 3. The API has most of its examples using authentication
//     credentials like so:

//       https://USERNAME:PASSWORD@opensky-network.org/api/flights/arrival?airport=E..etc..

//     You don’t need actual credentials to use the API. For
//     the same example request shown above just remove the
//     “USERNAME:PASSWORD@” part like so:

//       https://opensky-network.org/api/flights/arrival?airport=E..etc...

// 4.  Implement the functionality described above, using data
//     fetched dynamically from the Arrivals-By-Airport API
//     described here:

//       https://opensky-network.org/apidoc/rest.html#arrivals-by-airport

// 5.  Output any results through the main() method of
//     your program so that we can easily run them.


// ====== FAQs =====

// Q:  How do I know if my solution is correct?
// A:  Make sure you've read the prompt carefully and you're
//     convinced your program does what you think it should
//     in the common case. If your program does what the prompt
//     dictates, you will get full credit. We do not use an
//     auto-grader, so we do not have any values for you to
//     check correctness against.

// Q:  What is Delphix looking for in a solution?
// A:  After submitting your code, we'll have a pair of engineers
//     evaluate it and determine next steps in the interview process.
//     We are looking for correct, easy-to-read, robust code.
//     Specifically, ensure your code is idiomatic and laid out
//     logically. Ensure it is correct. Ensure it handles all edge
//     cases and error cases elegantly.

// Q:  If I need a clarification, who should I ask?
// A:  Send all questions to the email address that sent you
//     this document, and an engineer at Delphix will get
//     back to you ASAP (we're pretty quick during normal
//     business hours).

// Q:  How long should this question take me?
// A:  Approximately 1 hour, but it could take more or less
//     depending on your experience with web APIs and the
//     language you choose.

// Q:  When is this due?
// A:  We will begin grading your answer 24 hours after it is
//     sent to you, so that is the deadline.

// Q:  What if something comes up and I cannot complete the
//     problem during the 24 hours?
// A:  Reach out to us and let us know! We will work with you
//     to figure out an extension if necessary.

// Q:  How do I turn in my solution?
// A:  Anything you've typed into this document will be saved.
//     If you were given a Takehome question, there should be a Submit
//     Button in the bottom right of the coderpad page. If you do not
//     see such a button, feel free to email us when you are done with
//     your solution. We will respond confirming we've received the
//     solution within 24 hours.

// Q:  Can I use any external resources to help me?
// A:  Absolutely! Feel free to use any online resources you
//     like, but please don't collaborate with anyone else.

// Q:  Can I use my favorite library in my program?
// A:  Unfortunately, there is no way to load external
//     libraries into CoderPad, so you must stick to what
//     they provide out of the box for your language:

//         https://coderpad.io/languages

//     If you really want to use something that's not
//     available, email the address that sent you this link
//     and we will work with you to find a solution.

// Q:  Can I code this up in a different IDE?
// A:  Of course! However, we do not have your environment
//     to run your code in. We ask that you submit your final
//     code via CoderPad (and make sure it can run). This gives
//     our graders the ability to run your code rather than guessing.

// Q:  Why does my program terminate unexpectedly in
//     CoderPad, and why can't I read from stdin or pass
//     arguments on the command line?
// A:  CoderPad places a limit on the runtime and amount of
//     output your code can use, but you should be able to
//     make your code fit within those limits. You can hard
//     code any arguments or inputs to the program in your
//     main() method or in your tests.

// Q:  I'm a Vim/Emacs fan -- is there any way to use those
//     keybindings? What about changing the tab width? Font
//     size?
// A:  Yes! Hit the button at the bottom of the screen that
//     looks like a keyboard.

}

