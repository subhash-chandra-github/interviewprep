package com.interviewprep.company;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by subhash on 17/11/2022.
 */
public class Arcecium {


    static class UserDetails {
        private int id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String website;
        private Company company;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }
    }

    static class Company {
        private String name;
        private String basename;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBasename() {
            return basename;
        }

        public void setBasename(String basename) {
            this.basename = basename;
        }
    }

    static class Geo {

        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }

    static class Address {

        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Gson gson = new Gson();
        String data = "[  {    \"id\": 1,    \"name\": \"Vinay Kumar\",    \"username\": \"vinayk\",    \"email\": \"vinayk@abcu.com\",    \"address\": {      \"street\": \"random1\",      \"suite\": \"APR\",      \"city\": \"Mumbai\",      \"zipcode\": \"192008-13874\",      \"geo\": {        \"lat\": \"-17.3159\",        \"lng\": \"91.1496\"      }    },    \"website\": \"seuinfra.org\",    \"company\": {      \"name\": \"sec infra\",      \"basename\": \"seu infra tech\"    }  },  {    \"id\": 2,    \"name\": \"Anandita Basu\",    \"username\": \"PrernaB\",    \"email\": \"Anandita.b@abc1f.cpm\",    \"address\": {      \"street\": \"Hawroh Bridge\",      \"suite\": \"ATY\",      \"city\": \"Kolkata\",      \"zipcode\": \"700001\",      \"geo\": {        \"lat\": \"-67.3159\",        \"lng\": \"91.8006\"      }    },    \"website\": \"techInfar.org\",    \"company\": {      \"name\": \"tech infar world\",      \"basename\": \"seu infra tech\"    }  },  {    \"id\": 3,    \"name\": \"Charvi Malhotra\",    \"username\": \"CharviM\",    \"email\": \"Charvim@mail.net\",    \"address\": {      \"street\": \"whitehouse Extension\",      \"suite\": \"A782\",      \"city\": \"Bengaluru\",      \"zipcode\": \"560001\",      \"geo\": {        \"lat\": \"-68.6102\",        \"lng\": \"-47.0653\"      }    },    \"website\": \"Infesystem.info\",    \"company\": {      \"name\": \"infeystems\",      \"basename\": \"Information E stsyem\"    }  },  {    \"id\": 4,    \"name\": \"Patricia Wilson\",    \"username\": \"WilsonP\",    \"email\": \"Wilsonp@mymail.org\",    \"address\": {      \"street\": \"Kalangut\",      \"suite\": \"Apt 6\",      \"city\": \"Panjim\",      \"zipcode\": \"403110\",      \"geo\": {        \"lat\": \"29.4572\",        \"lng\": \"-164.2990\"      }    },    \"website\": \"giant.Tech.biz\",    \"company\": {      \"name\": \"robert-techgiant\",      \"basename\": \"transition cutting-edge web services provider\"    }  },  {    \"id\": 5,    \"name\": \"Chetan Chauhan \",    \"username\": \"ChauhanChetan\",    \"email\": \"chetanc@mailme.in\",    \"address\": {      \"street\": \"Willow Walks\",      \"suite\": \"1351\",      \"city\": \"Hyderabad\",      \"zipcode\": \"500001\",      \"geo\": {        \"lat\": \"-31.8129\",        \"lng\": \"62.5342\"      }    },    \"website\": \"sanganak.info\",    \"company\": {      \"name\": \"Sanganak\",      \"basename\": \"end-to-end solution provider\"    }  },  {    \"id\": 6,    \"name\": \"Pragya Mathur\",    \"username\": \"mathurpragya\",    \"email\": \"pragya.mathur@mail.in\",    \"address\": {      \"street\": \"Rosewind Crossing\",      \"suite\": \"A-50\",      \"city\": \"Delhi\",      \"zipcode\": \"100001\",      \"geo\": {        \"lat\": \"-71.4197\",        \"lng\": \"71.7478\"      }    },        \"website\": \"hola.in\",    \"company\": {      \"name\": \"Hola Technocrafts\",      \"basename\": \"e-enable innovative applications\"    }  },  {    \"id\": 7,    \"name\": \"Krish Ahuja\",    \"username\": \"ahujakrish\",    \"email\": \"ahujakrish@mails.in\",    \"address\": {      \"street\": \"Havmore Extension\",      \"suite\": \"A3221\",      \"city\": \"Bengalura\",      \"zipcode\": \"560058\",      \"geo\": {        \"lat\": \"24.8918\",        \"lng\": \"21.8984\"      }    },    \"website\": \"tellybelly.in\",    \"company\": {      \"name\": \"Telly Belly\",      \"basename\": \"generate application support solutions\"    }  },  {    \"id\": 8,    \"name\": \"Nilofar Anam\",    \"username\": \"anamnilofar\",    \"email\": \"nilofaranam.d@maily.me\",    \"address\": {      \"street\": \"fountains lane\",      \"suite\": \"B902\",      \"city\": \"pune\",      \"zipcode\": \"400001\",      \"geo\": {        \"lat\": \"-14.3990\",        \"lng\": \"-120.7677\"      }    },    \"website\": \"techoba.com\",    \"company\": {      \"name\": \"Tech Happy Group\",      \"basename\": \"e-support to middle retailers\"    }  },  {    \"id\": 9,    \"name\": \"Garima Gupta\",    \"username\": \"Garimag\",    \"email\": \"gupta.garima22@myemails.io\",    \"address\": {      \"street\": \"Little Park\",      \"suite\": \"B68\",      \"city\": \"Surat\",      \"zipcode\": \"764920\",      \"geo\": {        \"lat\": \"24.6463\",        \"lng\": \"-168.8889\"      }    },    \"website\": \"contech.com\",    \"company\": {      \"name\": \"Configs Techs\",      \"basename\": \"real-time technologies support\"    }  },  {    \"id\": 10,    \"name\": \"Dharma Dhar\",    \"username\": \"Dharmadhar55\",    \"email\": \"dharmadhar55@olexa.in\",    \"address\": {      \"street\": \"Anam Street\",      \"suite\": \"198/23\",      \"city\": \"Surat\",      \"zipcode\": \"314280\",      \"geo\": {        \"lat\": \"-38.2386\",        \"lng\": \"57.2232\"      }    },     \"website\": \"ampitech.net\",    \"company\": {      \"name\": \"Ampitech Solutions Ltd\",      \"basename\": \"target end-to-end startup support\"    }  }]";
        List<UserDetails> userDetailsList = Arrays.asList(gson.fromJson(data, UserDetails[].class));
        String n = "tom";
        String feilName = "username";
        List<Integer> ids = new ArrayList<>();
        for(UserDetails userDetails : userDetailsList){
            boolean b = contains(userDetails,feilName,"EQUALS",n);
            if(b){
                ids.add(userDetails.getId());
            }

        }
        System.out.println(ids);
    }

    static boolean contains(Object userDetails, String fieldName, String operator, String value) throws NoSuchFieldException, IllegalAccessException {

        if(fieldName.contains(".")){
            String[] fieldNames = fieldName.split("[.]", 0);;
            for(int i=0;i<fieldNames.length;i++){
                Field field = userDetails.getClass().getDeclaredField(fieldNames[i]);
                field.setAccessible(true);
                userDetails = field.get(userDetails);
            }

        }else {
              Field field = userDetails.getClass().getDeclaredField(fieldName);
              field.setAccessible(true);
               userDetails = field.get(userDetails);
        }
        if(operator.equals("EQUALS")){
            if(userDetails.equals(value)){
                return true;
            }
        }

        if(operator.equals("IN")){

            List<String> values = Arrays.asList((value.split("[,]", 0)));
            if(value.contains(userDetails.toString())){
                return true;
            }
        }

        return false;


    }


}
