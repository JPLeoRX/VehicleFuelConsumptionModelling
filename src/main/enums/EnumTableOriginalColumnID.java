package main.enums;

/**
 * Collection of descriptive indexes for columns of the original data set table
 *
 * The ordering and indexing follows the table itself
 *
 * The comments are copied from "Data Description" section of https://www.fueleconomy.gov/feg/ws/index.shtml#vehicle
 *
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public interface EnumTableOriginalColumnID
{
    int barrels08 = 0;                               // annual petroleum consumption in barrels for fuelType1 (1)
    int barrelsA08 = 1;                              // annual petroleum consumption in barrels for fuelType2 (1)
    int charge120 = 2;                               // time to charge an electric vehicle in hours at 120 V
    int charge240 = 3;                               // time to charge an electric vehicle in hours at 240 V
    int city08 = 4;                                  // city MPG for fuelType1 (2)
    int city08U = 5;                                 // unrounded city MPG for fuelType1 (2), (3)
    int cityA08 = 6;                                 // city MPG for fuelType2 (2)
    int cityA08U = 7;                                // unrounded city MPG for fuelType2 (2), (3)
    int cityCD = 8;                                  // city gasoline consumption (gallons/100 miles) in charge depleting mode (4)
    int cityE = 9;                                   // city electricity consumption in kw-hrs/100 miles
    int cityUF = 10;                                 // EPA city utility factor (share of electricity) for PHEV
    int co2 = 11;                                    // tailpipe CO2 in grams/mile for fuelType1 (5)
    int co2A = 12;                                   // tailpipe CO2 in grams/mile for fuelType2 (5)
    int co2TailpipeAGpm = 13;                        // tailpipe CO2 in grams/mile for fuelType2 (5)
    int co2TailpipeGpm = 14;                         // tailpipe CO2 in grams/mile for fuelType1 (5)
    int comb08 = 15;                                 // combined MPG for fuelType1 (2)
    int comb08U = 16;                                // unrounded combined MPG for fuelType1 (2), (3)
    int combA08 = 17;                                // combined MPG for fuelType2 (2)
    int combA08U = 18;                               // unrounded combined MPG for fuelType2 (2), (3)
    int combE = 19;                                  // combined electricity consumption in kw-hrs/100 miles
    int combinedCD = 20;                             // combined gasoline consumption (gallons/100 miles) in charge depleting mode (4)
    int combinedUF = 21;                             // EPA combined utility factor (share of electricity) for PHEV
    int cylinders = 22;                              // engine cylinders
    int displ = 23;                                  // engine displacement in liters
    int drive = 24;                                  // drive axle type
    int engId = 25;                                  // EPA model type index
    int eng_dscr = 26;                               // engine descriptor; see http://www.fueleconomy.gov/feg/findacarhelp.shtml#engine
    int feScore = 27;                                // EPA Fuel Economy Score (-1 = Not available)
    int fuelCost08 = 28;                             // annual fuel cost for fuelType1 ($) (7)
    int fuelCostA08 = 29;                            // annual fuel cost for fuelType2 ($) (7)
    int fuelType = 30;                               // fuel type with fuelType1 and fuelType2 (if applicable)
    int fuelType1 = 31;                              // fuel type 1. For single fuel vehicles, this will be the only fuel. For dual fuel vehicles, this will be the conventional fuel.
    int ghgScore = 32;                               // EPA GHG score (-1 = Not available)
    int ghgScoreA = 33;                              // EPA GHG score for dual fuel vehicle running on the alternative fuel (-1 = Not available)
    int highway08 = 34;                              // highway MPG for fuelType1 (2)
    int highway08U = 35;                             // unrounded highway MPG for fuelType1 (2), (3)
    int highwayA08 = 36;                             // highway MPG for fuelType2 (2)
    int highwayA08U = 37;                            // unrounded highway MPG for fuelType2 (2),(3)
    int highwayCD = 38;                              // highway gasoline consumption (gallons/100miles) in charge depleting mode (4)
    int highwayE = 39;                               // highway electricity consumption in kw-hrs/100 miles
    int highwayUF = 40;                              // EPA highway utility factor (share of electricity) for PHEV
    int hlv = 41;                                    // hatchback luggage volume (cubic feet) (8)
    int hpv = 42;                                    // hatchback passenger volume (cubic feet) (8)
    int id = 43;                                     // vehicle record id
    int lv2 = 44;                                    // 2 door luggage volume (cubic feet) (8)
    int lv4 = 45;                                    // 4 door luggage volume (cubic feet) (8)
    int make = 46;                                   // manufacturer (division)
    int model = 47;                                  // model name (carline)
    int mpgData = 48;                                // has My MPG data; see yourMpgVehicle and yourMpgDriverVehicle
    int phevBlended = 49;                            // if true, this vehicle operates on a blend of gasoline and electricity in charge depleting mode
    int pv2 = 50;                                    // 2-door passenger volume (cubic feet) (8)
    int pv4 = 51;                                    // 4-door passenger volume (cubic feet) (8)
    int range = 52;                                  // EPA range for fuelType2
    int rangeCity = 53;                              // EPA city range for fuelType1
    int rangeCityA = 54;                             // EPA city range for fuelType2
    int rangeHwy = 55;                               // EPA highway range for fuelType1
    int rangeHwyA = 56;                              // EPA highway range for fuelType2
    int trany = 57;                                  // transmission
    int UCity = 58;                                  // unadjusted city MPG for fuelType1; see the description of the EPA test procedures
    int UCityA = 59;                                 // unadjusted city MPG for fuelType2; see the description of the EPA test procedures
    int UHighway = 60;                               // unadjusted highway MPG for fuelType1; see the description of the EPA test procedures
    int UHighwayA = 61;                              // unadjusted highway MPG for fuelType2; see the description of the EPA test procedures
    int VClass = 62;                                 // EPA vehicle size class
    int year = 63;                                   // model year
    int youSaveSpend = 64;                           // you save/spend over 5 years compared to an average car ($). Savings are positive; a greater amount spent yields a negative number. For dual fuel vehicles, this is the cost savings for gasoline
    int guzzler = 65;                                // if G or T, this vehicle is subject to the gas guzzler tax
    int trans_dscr = 66;                             // transmission descriptor; see http://www.fueleconomy.gov/feg/findacarhelp.shtml#trany
    int tCharger = 67;                               // if T, this vehicle is turbocharged
    int sCharger = 68;                               // if S, this vehicle is supercharged
    int atvtype = 69;                                // type of alternative fuel or advanced technology vehicle
    int fuelType2 = 70;                              // fuel type 2. For dual fuel vehicles, this will be the alternative fuel (e.g. E85, Electricity, CNG, LPG). For single fuel vehicles, this field is not used
    int rangeA = 71;                                 // EPA range for fuelType2
    int evMotor = 72;                                // electric motor (kw-hrs)
    int mfrCode = 73;                                // 3-character manufacturer code
    int c240Dscr = 74;                               // electric vehicle charger description
    int charge240b = 75;                             // time to charge an electric vehicle in hours at 240 V using the alternate charger
    int c240bDscr = 76;                              // electric vehicle alternate charger description
    int createdOn = 77;                              // date the vehicle record was created (ISO 8601 format)
    int modifiedOn = 78;                             // date the vehicle record was last modified (ISO 8601 format)
    int startStop = 79;                              // vehicle has start-stop technology (Y, N, or blank for older vehicles)
    int phevCity = 80;                               // EPA composite gasoline-electricity city MPGe for plug-in hybrid vehicles
    int phevHwy = 81;                                // EPA composite gasoline-electricity highway MPGe for plug-in hybrid vehicles
    int phevComb = 82;                               // EPA composite gasoline-electricity combined city-highway MPGe for plug-in hybrid vehicles
}