package main.enums;

/**
 * Collection of descriptive indexes for columns of the modified data set table
 *
 * The ordering and indexing follows the table itself
 *
 * The comments are copied from "Data Description" section of https://www.fueleconomy.gov/feg/ws/index.shtml#vehicle
 *
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public interface EnumTableModifiedColumnID
{
    int city08 = 0;                                 // city MPG for fuelType1 (2)
    int comb08 = 1;                                 // combined MPG for fuelType1 (2)
    int cylinders = 2;                              // engine cylinders
    int displ = 3;                                  // engine displacement in liters
    int drive = 4;                                  // drive axle type
    int fuelType1 = 5;                              // fuel type 1. For single fuel vehicles, this will be the only fuel. For dual fuel vehicles, this will be the conventional fuel.
    int highway08 = 6;                              // highway MPG for fuelType1 (2)
    int hlv = 7;                                    // hatchback luggage volume (cubic feet) (8)
    int hpv = 8;                                    // hatchback passenger volume (cubic feet) (8)
    int lv2 = 9;                                    // 2 door luggage volume (cubic feet) (8)
    int lv4 = 10;                                   // 4 door luggage volume (cubic feet) (8)
    int make = 11;                                  // manufacturer (division)
    int model = 12;                                 // model name (carline)
    int pv2 = 13;                                   // 2-door passenger volume (cubic feet) (8)
    int pv4 = 14;                                   // 4-door passenger volume (cubic feet) (8)
    int trany = 15;                                 // transmission
    int UCity = 16;                                 // unadjusted city MPG for fuelType1; see the description of the EPA test procedures
    int UHighway = 17;                              // unadjusted highway MPG for fuelType1; see the description of the EPA test procedures
    int VClass = 18;                                // EPA vehicle size class
    int year = 19;                                  // model year
    int guzzler = 20;                               // if G or T, this vehicle is subject to the gas guzzler tax
    int tCharger = 21;                              // if T, this vehicle is turbocharged
    int sCharger = 22;                              // if S, this vehicle is supercharged
    int atvtype = 23;                               // type of alternative fuel or advanced technology vehicle
    int fuelType2 = 24;                             // fuel type 2. For dual fuel vehicles, this will be the alternative fuel (e.g. E85, Electricity, CNG, LPG). For single fuel vehicles, this field is not used
    int startStop = 25;                             // vehicle has start-stop technology (Y, N, or blank for older vehicles)
}