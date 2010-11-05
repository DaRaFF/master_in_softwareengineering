//==============================================================================
//        * Letsch Informatik *       www.LetsInfo.ch       CH-8636 Wald
//          Beratung, Ausbildung und Realisation in Software-Engineering
//==============================================================================
// Project   : Nachdiplomstudium Software-Engineering NDS-SE
// Modul     : C++
// Title     : Support-Klasse  "Statistic-Stopwatch" : StatisticStopWatch.cpp
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

#include "StatisticStopWatch.h"

StatisticStopWatch::StatisticStopWatch() {  
  mCounter = 0;
  mLast  = 0;
  mMin   = LONG_MAX;
  mMax   = 0;
  mAvg   = 0;
  mMeasuring = false;
}


int StatisticStopWatch::start() {
  if ( ! mMeasuring) {
    mMeasuring = true;
    mCounter++;
    gettimeofday(&mStart, &mTzp); 
    return 1;
  } 
  else {
    return 0;
  }
}


int StatisticStopWatch::stop() {
  if (mMeasuring) {
    gettimeofday(&mStop, &mTzp); 
    timeStatistic(); 
    mMeasuring = false;
    return 1;
  } 
  else {
    return 0;
  }
} 


void StatisticStopWatch::reset() {
  mCounter = 0;
  mLast  = 0;
  mMin   = LONG_MAX;
  mMax   = 0;
  mAvg   = 0;
  mMeasuring = false;
}

void StatisticStopWatch::printTimes(const char* pDescription) {
  char cp[80];
  sprintf(cp, "%-20s : (nr/min/max/avg) = %5d %8.0f %8.0f %8.0f", 
          pDescription, mCounter, 
          ((double)mMin / 1000), ((double)mMax / 1000), (mAvg / 1000));
  cout << cp << endl;
}


bool StatisticStopWatch::printTime(const char* pDescription, int pDivisor) {
  if (mCounter != 1) {
    cerr << "ERROR: StatisticStopWatch::printTime() with mCounter = " 
   << mCounter << endl;
    return false;
  }
  char cp[80];
  if (pDivisor != 1) {
    sprintf(cp, "%-20s = %f ms", pDescription, ((double)mLast / 1000 / pDivisor));
  }
  else {
    sprintf(cp, "%-20s = %10ld ms", pDescription, (mLast / 1000));
  }
  cout << cp << endl;
  return true;
}



void StatisticStopWatch::timeStatistic() {
  long t_lapsed;
  struct timeval tp_lapsed;

  if (mStart.tv_usec > mStop.tv_usec)
  {
    mStart.tv_usec -= 1000000;
    mStart.tv_sec++;
  }
  tp_lapsed.tv_usec = mStop.tv_usec - mStart.tv_usec;
  tp_lapsed.tv_sec  = mStop.tv_sec  - mStart.tv_sec;
  t_lapsed = tp_lapsed.tv_sec * 1000000 + tp_lapsed.tv_usec;
  mLast    = t_lapsed;
  mAvg = (mAvg * (mCounter-1) + t_lapsed) / mCounter;
  if (t_lapsed < mMin)  mMin = t_lapsed;
  if (t_lapsed > mMax)  mMax = t_lapsed;
}

