package com.interviewprep.lld.VendingMachine;

/**
 * Created by subhash on 28/11/2022.
 */
public class VendingMachineFactory {
    public static VendingMachine createVendingMachine() {
        return new VendingMachineImpl();
    }
}
