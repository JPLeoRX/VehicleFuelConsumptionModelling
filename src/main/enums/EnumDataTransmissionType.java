package main.enums;

/**
 * Collection of numeric values for transmission types used in the data set
 * @author Lev Ertuna - leo.ertuna@gmail.com
 */
public interface EnumDataTransmissionType
{
    int MANUAL = 1;                         // Conventional manual
    int AUTOMATIC = 2;                      // Conventional automatic
    int AUTOMATED_MANUAL = 3;               // Semi-automatic, allows driver to either change gears manually or use the automatic mode
    int AUTOMATED_VARIABLE = 4;             // Continuously variable transmission, it changes seamlessly through a continuous range of gear ratios
}