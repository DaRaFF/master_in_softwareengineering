//==============================================================================
//        * Letsch Informatik *       www.LetsInfo.ch       CH-8636 Wald
//          Beratung, Ausbildung und Realisation in Software-Engineering
//==============================================================================
// Project   : Nachdiplomstudium Software-Engineering NDS-SE
// Modul     : C++
// Title     : Support-Klasse  "Statistic-Stopwatch" : StatisticStopWatch.h
// Author    : Thomas Letsch 
// Tab-Width : 2 
/*///===========================================================================
* Description: Klasse für Zeitmessungen mit Statistic-Funktion.
               Zu 'bedienen' wie eine Stop-Uhr.
* History    : 26.08.94: Initial Version 
               13.12.02: Kosmetik
               02.01.04: printTime() hinzugefuegt.
* Version    : $Revision: 1.5 $  $Date: 2005/09/29 20:14:49 $
/*///===========================================================================
//       1         2         3         4         5         6         7         8
//345678901234567890123456789012345678901234567890123456789012345678901234567890
//==============================================================================

#ifndef STATISTICSTOPWATCH_H
#define STATISTICSTOPWATCH_H 1

#include <iostream> 
#include <sys/time.h>
#include <climits>
#include <cstdlib>
#include <cstdio>

using namespace std;

class StatisticStopWatch {
  public:

    StatisticStopWatch();

    int  start();        // Start a Measurement
    int  stop();         // Stop  a Measurement  
    void reset();        // Reset StopWatch to Zero 

    // Print Time-Statistic to stdout (in Milliseconds).
    // pDescription: Prefix which is printed first.
    void printTimes(const char* pDescription);  

    // Print Time to stdout (in Milliseconds).
    // This Methode shall only be used with just one Measurement.
    // pDescription: Prefix which is printed first.
    // pDivisor:     The actual measured Time will be diveded by pDivisor.
    // return:       'false' if mCounter != 0, otherwise 'true'.
    bool printTime(const char* pDescription, int pDivisor = 1);  

  private:
    void timeStatistic();

    int     mCounter;       // Number of Measurements
    long    mLast;          // Last messured Time

    long    mMin;           // Minimal messured Time
    long    mMax;           // Maximal messured Time
    double  mAvg;           // Average of all messured Times

    struct  timeval mStart; // Begin-Time of one Measurement
    struct  timeval mStop;  // End-Time   of one Measurement
    bool    mMeasuring;     // True while measuring
    struct  timezone mTzp;  // not used

}; // class StatisticStopWatch
#endif 
