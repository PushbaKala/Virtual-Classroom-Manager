import java.util.*;
import java.util.logging.*;

class classroom {
    private static final Logger logger = Logger.getLogger(classroom.class.getName());

    String name;
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<String> assignments = new ArrayList<String>();
    int assignmentLength = 0;
    HashMap<String, Integer> assignmentdetails = new HashMap<>();

    void addStudent(int stid /* , String name */) {
        int i, f = 0, l = this.students.size();
        for (i = 0; i < l; i++) {
            if (this.students.get(i).studentid == stid) {
                f = 1;
                break;
            }
        }
        if (f == 1) {
            logger.warning("Student " + stid + " already exists.");
            System.out.println("Student " + stid + " not found");
            return;
        }
        Student st = new Student();
        st.studentid = stid;
        // st.name = name;
        for (i = 0; i < this.assignments.size(); i++) {
            st.assignmentstatus.add(false);
        }
        this.students.add(st);
        logger.info("Student " + stid + " has been added in " + this.name);
        System.out.println("Student " + stid + " has been added in " + this.name);
    }

    void displayStudents() {
        int l = this.students.size();
        logger.info("Displaying students in classroom " + this.name);
        System.out.println("Students in this classroom are:-");
        for (int i = 0; i < l; i++) {
            Student st = this.students.get(i);
            System.out.println(st.studentid);
        }
    }

    void addAssignment(String assignmentname) {
        if (this.assignments.contains(assignmentname)) {
            logger.warning("Assignment " + assignmentname + " already exists for " + this.name);
            System.out.println("Assignment " + assignmentname + " already exists for " + this.name);
        } else {
            this.assignments.add(assignmentname);
            int l = this.students.size();
            for (int i = 0; i < l; i++) {
                this.students.get(i).assignmentstatus.add(false);
            }
            this.assignmentLength++;
            this.assignmentdetails.put(assignmentname, this.assignmentLength);
            logger.info("Assignment " + assignmentname + " assigned for class " + this.name);
            System.out.println("Assignment " + assignmentname + " assigned for class " + this.name);
        }
    }

    void submitAssignment(String assgnname, int studentid) {
        if (!this.assignmentdetails.containsKey(assgnname)) {
            logger.warning("Assignment " + assgnname + " not found");
            System.out.println("Assignment " + assgnname + " not found");
            return;
        }
        int i, f = 0, l = this.students.size();
        int assingmentid = this.assignmentdetails.get(assgnname);
        for (i = 0; i < l; i++) {
            if (this.students.get(i).studentid == studentid) {
                f = 1;
                break;
            }
        }
        if (f == 0) {
            logger.warning("Student " + studentid + " not found");
            System.out.println("Student " + studentid + " not found");
            return;
        }
        Student st = this.students.get(i);
        logger.info("Student " + studentid + " submitting assignment " + assgnname);
        st.assignmentstatus.set(assingmentid - 1, true);
        String assgnString;
        Boolean status;
        System.out.println(assgnname + " has been submitted for student " + studentid);
        System.out.println("Assignment details of the student are:");
        for (i = 0; i < this.assignmentLength; i++) {
            assgnString = this.assignments.get(i);
            status = st.assignmentstatus.get(i);
            if (status) {
                System.out.println(assgnString + " : COMPLETED");
            } else {
                System.out.println(assgnString + " : NOT COMPLETED");
            }
        }
    }

    void displayAssignmentStatus(String assignment) {
        if (!this.assignmentdetails.containsKey(assignment)) {
            logger.warning("Assignment " + assignment + " not found");
            System.out.println("Assignment " + assignment + " not found");
            return;
        }
        int studentsSize = this.students.size();
        int assignmentid = this.assignmentdetails.get(assignment);
        logger.info("Displaying status for assignment " + assignment + " in classroom " + this.name);
        //String studentname;
        int studentid;
        Boolean status;
        System.out.println(assignmentid + " : " + assignment);
        for (int i = 0; i < studentsSize; i++) {
            Student st = this.students.get(i);
            studentid = st.studentid;
            // studentname = st.name;
            status = st.assignmentstatus.get(assignmentid - 1);
            if (status) {
                System.out.println(studentid + " - COMPLETED");
            } else {
                System.out.println(studentid + " - NOT COMPLETED");
            }
        }
    }
}

