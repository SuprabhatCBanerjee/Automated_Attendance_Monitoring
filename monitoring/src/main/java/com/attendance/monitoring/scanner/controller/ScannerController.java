package com.attendance.monitoring.scanner.controller;

public class ScannerController {
    /**
     * on api call ==> abc.in/attendance/record <===> type POST
     * step 1 => data packet look like
     * {
     *      "scannerNumber" : "SCNR_123", //same as room number
     *      "timeOfRecord" : "10:35"//am
     *      "students" :[
     *          {
     *              "studentId" : "stud_1234",
     *              "validationCount" : "7", //min 6 let
     *              "classIn" : "10:02",
     *              "classOut" : "10:40"// or last seen in that period
     *          }
     *      ] 
     * }
     * 
     * //now we got data of first period on server ==> server works
     * 
     * step2 : fetch timetable ==> subjectId, facultyId, day, class time using room number
     * step3 : from fetch data we do some validation like period number finding,
     *         day validation , etc as required
     * step4 : after doing all the validation work server finally push data to database
     * 
     * step5 : all things works on offline server,
     *         in the night or as client requirements we push data to cloud server  
     */
}
