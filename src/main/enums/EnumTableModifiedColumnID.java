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
    int fuelType = 5;                               // fuel type with fuelType1 and fuelType2 (if applicable)
    int fuelType1 = 6;                              // fuel type 1. For single fuel vehicles, this will be the only fuel. For dual fuel vehicles, this will be the conventional fuel.
    int highway08 = 7;                              // highway MPG for fuelType1 (2)
    int hlv = 8;                                    // hatchback luggage volume (cubic feet) (8)
    int hpv = 9;                                    // hatchback passenger volume (cubic feet) (8)
    int lv2 = 10;                                   // 2 door luggage volume (cubic feet) (8)
    int lv4 = 11;                                   // 4 door luggage volume (cubic feet) (8)
    int make = 12;                                  // manufacturer (division)
    int model = 13;                                 // model name (carline)
    int pv2 = 14;                                   // 2-door passenger volume (cubic feet) (8)
    int pv4 = 15;                                   // 4-door passenger volume (cubic feet) (8)
    int trany = 16;                                 // transmission
    int UCity = 17;                                 // unadjusted city MPG for fuelType1; see the description of the EPA test procedures
    int UHighway = 18;                              // unadjusted highway MPG for fuelType1; see the description of the EPA test procedures
    int VClass = 19;                                // EPA vehicle size class
    int year = 20;                                  // model year
    int guzzler = 21;                               // if G or T, this vehicle is subject to the gas guzzler tax
    int tCharger = 22;                              // if T, this vehicle is turbocharged
    int sCharger = 23;                              // if S, this vehicle is supercharged
    int atvtype = 24;                               // type of alternative fuel or advanced technology vehicle
    int fuelType2 = 25;                             // fuel type 2. For dual fuel vehicles, this will be the alternative fuel (e.g. E85, Electricity, CNG, LPG). For single fuel vehicles, this field is not used
    int startStop = 26;                             // vehicle has start-stop technology (Y, N, or blank for older vehicles)
}