import java.util.*;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

class Hospital {

  private String hospitalName;
  private String slotDay;
  private int slotTiming;
  private int serialNum;
  private int drChoosen;

  public HashMap<Integer, Doctor> doctorDatabase = new HashMap<Integer, Doctor>();
  private HashMap<Integer, Patient> patientDatabase = new HashMap<Integer, Patient>();

  Hospital() {

    hospitalName = "N N Hospital";
    doctorDatabase.put(1, new Doctor("Dr. Rajesh Arora", "Dermatology Department"));
    doctorDatabase.put(2, new Doctor("Dr. Rakul Preet", "Cardiology Department"));
    doctorDatabase.put(3, new Doctor("Dr. Mukesh Ambani", "Gynaecology Department"));
    doctorDatabase.put(4, new Doctor("Dr. Priyanka Shah", "Orthology Department"));
  }

  class Patient {
    private String patientName;
    private int age;
    private long mobileNum;

  }

  class Doctor {
    private String doctorName;
    private String doctorDepartment;

    Doctor(String drName, String drDepartment) {
      this.doctorName = drName;
      this.doctorDepartment = drDepartment;
    }


  }


  public void takeAppointment() {

    Patient patient = new Patient();

    patient.patientName = enterPatientName();
    System.out.println();
    patient.age = enterPatientAge();
    System.out.println();
    patient.mobileNum = enterPatientMobileNum();
    System.out.println();
    printDoctorsList();
    System.out.println();
    chooseDoctor();
    System.out.println();
    selectSlotDay();
    System.out.println();
    selectSlotTiming();
    System.out.println();

    if (slotTiming == 1 || slotTiming == 2 || slotTiming == 3) {

      if (slotTiming == 1) {
        System.out
            .println(patient.patientName + " your Appointment is Booked for " + slotDay + " between 10 - 12" + " with "
                + doctorDatabase.get(drChoosen).doctorName + " from " + doctorDatabase.get(drChoosen).doctorDepartment);
      } else if (slotTiming == 2) {
        System.out
            .println(patient.patientName + " your Appointment is Booked for " + slotDay + " between 12 - 2" + " with "
                + doctorDatabase.get(drChoosen).doctorName + " from " + doctorDatabase.get(drChoosen).doctorDepartment);
      } else if (slotTiming == 3) {
        System.out
            .println(patient.patientName + " your Appointment is Booked for " + slotDay + " between 3 - 5" + " with "
                + doctorDatabase.get(drChoosen).doctorName + " from " + doctorDatabase.get(drChoosen).doctorDepartment);
      }
      serialNum++;

      patientDatabase.put(serialNum, patient);

      System.out.println();

     // printPatientDatabase();            // optional if you want to see Patient database

      System.out.println();
      bookAgain();

    }
  }

  private void printDoctorsList() {
    Iterator<Map.Entry<Integer, Doctor>> itr = doctorDatabase.entrySet().iterator();

    while (itr.hasNext()) {
      Entry<Integer, Hospital.Doctor> entry = itr.next();
      System.out.println("S.No. : " + entry.getKey() +
          ", Doctor Name : " + entry.getValue().doctorName +
          " , Doctor Department : " + entry.getValue().doctorDepartment);
    }

    System.out.println();
  }

  private void printPatientDatabase() {
    Iterator<Map.Entry<Integer, Patient>> itr = patientDatabase.entrySet().iterator();

    while (itr.hasNext()) {
      Map.Entry<Integer, Patient> entry = itr.next();
      System.out.println("S.No. = " + entry.getKey() +
          ", Patient Name = " + entry.getValue().patientName +
          " , Age = " + entry.getValue().age +
          " , Mobile Number = " + entry.getValue().mobileNum);
    }
  }


  private void chooseDoctor() {
    
    try {
    Scanner sc = new Scanner(System.in);
      
      drChoosen = 0;
      while (drChoosen == 0 || drChoosen > 4) {
        System.out.println("Enter  1, 2 ,3 ,4 to choose Doctor");
        drChoosen = sc.nextInt();
        if (drChoosen == 1 || drChoosen == 2 || drChoosen == 3 || drChoosen == 4) {
          break;
        } else {
          throw new InputMismatchException();
        }
      }

    } catch (InputMismatchException ie) {

      System.out.println("Please Enter a valid Input from options");

      chooseDoctor();

    } catch (Exception e) {
      System.out.println(e);
    }

  }

  private String enterPatientName() {
    String name = "";
    try {
      Scanner sc = new Scanner(System.in);
      while (name.isBlank()) {
        System.out.println("Enter your Name");
        name = sc.nextLine();
      }
    } catch (InputMismatchException ie) {
      System.out.println("Please Enter valid Name");
      enterPatientName();
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return name;
  }

  private int enterPatientAge() {
    int age = 0;
    try {
      Scanner sc = new Scanner(System.in);
      while (age == 0 || age > 120) {
        System.out.println("Enter your Age");
        age = sc.nextInt();
      }
    } catch (InputMismatchException ie) {
      System.out.println("Please Enter valid Input between 1 - 120");
      enterPatientAge();
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return age;
  }

  private long enterPatientMobileNum() {
    long mobNo = 0;
    try {
      Scanner sc = new Scanner(System.in);
      while (mobNo == 0) {
        System.out.println("Enter your 10 Digit Mobile Number");
        mobNo = sc.nextLong();
        if (String.valueOf(mobNo).length() != 10) {
          throw new InputMismatchException();
        }
      }
    } catch (InputMismatchException ie) {
      System.out.println("Please Enter valid Mobile Number");
      enterPatientMobileNum();
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return mobNo;
  }

  private void selectSlotDay() {

    try {
      Scanner sc = new Scanner(System.in);

      while (slotDay != "mon" || slotDay != "tue" || slotDay != "wed" || slotDay != "thur" || slotDay != "fri"
          || slotDay != "sat") {
        System.out.println("Enter Mon, Tue, Wed, Thur, Fri, Sat below to choose Your slot Day");
        slotDay = sc.next();
        if (slotDay.equalsIgnoreCase("mon")) {
          break;
        } else if (slotDay.equalsIgnoreCase("tue")) {
          break;
        } else if (slotDay.equalsIgnoreCase("wed")) {
          break;
        } else if (slotDay.equalsIgnoreCase("thur")) {
          break;
        } else if (slotDay.equalsIgnoreCase("fri")) {
          break;
        } else if (slotDay.equalsIgnoreCase("sat")) {
          break;
        }
      }
    } catch (InputMismatchException ie) {
      System.out.println("Pleas Enter a valid input from options");
      selectSlotDay();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private void selectSlotTiming() {

    try {
      Scanner sc = new Scanner(System.in);
      while (slotTiming != 1 || slotTiming != 2 || slotTiming != 3) {
        System.out.println("Choose Slot Timing : Enter 1 for 10 - 12 , Enter 2 for 12 - 2, Enter 3 for 3 - 5");
        slotTiming = sc.nextInt();
        if (slotTiming == 1) {
          break;
        } else if (slotTiming == 2) {
          break;
        } else if (slotTiming == 3) {
          break;
        }
      }
    } catch (InputMismatchException oe) {
      System.out.println("Pleas Enter a valid input from options");
      selectSlotTiming();

    } catch (Exception pe) {
      System.out.println(pe);
    }

  }

  private void bookAgain() {

    try {
      Scanner sc = new Scanner(System.in);
      System.out.println("Do you want To Book Another Appointment : Press y for YES or n for No");
      String ans = sc.next();
      if (ans.equalsIgnoreCase("y")) {
        takeAppointment();
      } else if (ans.equalsIgnoreCase("n")) {
        System.out.println("Thank You !");
      } else {
        throw new InputMismatchException();
      }
    } catch (InputMismatchException oe) {
      System.out.println("Pleas Enter a valid input from options");
      bookAgain();

    } catch (Exception pe) {
      System.out.println(pe);
    }

  }

}

public class DoctorAppointmentApp {

  public static void main(String[] args) {
    Hospital hospital = new Hospital();

    hospital.takeAppointment();

  }
}
