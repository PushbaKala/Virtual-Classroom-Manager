import java.util.*;
import java.util.logging.*;
public class classbooking {
    private static final Logger logger = Logger.getLogger(classbooking.class.getName());

    public static void main(String[] args) {
        HashMap<String, classroom> classes = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int studentid, k = 1;
        String Classname, choice, AssignmentName;
        System.out.println("VIRTUAL CLASSROOM MANAGER");
        System.out.println("You can perform the following actions");
        System.out.println("1. add_classroom\n" + //
                "2. remove_classroom\n" + //
                "3. list_classrooms\n" + //
                "4. add_student\n" + //
                "5. list_students\n" + //
                "6. schedule_assignment\n" + //
                "7. submit_assignment\n" + //
                "8. display_assignment_status");

        while (k == 1) {
            try {
                System.out.println("Enter choice:");
                System.out.print(">> ");
                choice = sc.next().toLowerCase();

                switch (choice) {
                    case "add_classroom":
                        try {
                            classroom croom = new classroom();
                            croom.name = sc.next();
                            if (classes.containsKey(croom.name)) {
                                logger.warning("Classroom " + croom.name + " already exists.");
                                System.out.println(croom.name + " already exists.");
                            } else {
                                classes.put(croom.name, croom);
                                logger.info("Classroom " + croom.name + " has been created.");
                                System.out.println("Classroom " + croom.name + " has been created.");
                            }
                        } catch (Exception e) {
                            logger.severe("Error creating classroom: " + e.getMessage());
                            System.out.println("Error creating classroom: " + e.getMessage());
                        }
                        break;
                    case "remove_classroom":
                        try {
                            Classname = sc.next();
                            if (classes.containsKey(Classname)) {
                                classes.remove(Classname);
                                logger.info("Classroom " + Classname + " removed.");
                                System.out.println("Classroom " + Classname + " removed.");
                            } else {
                                logger.warning("Classroom " + Classname + " does not exist.");
                                System.out.println("Classroom " + Classname + " does not exist.");
                            }
                        } catch (Exception e) {
                            logger.severe("Error removing classroom: " + e.getMessage());
                            System.out.println("Error removing classroom: " + e.getMessage());
                        }
                        break;
                    case "list_classrooms":
                        try {
                            logger.info("Listing all classrooms.");
                            System.out.println("The classrooms created are:");
                            for (Map.Entry<String, classroom> set : classes.entrySet()) {
                                System.out.println(set.getKey());
                            }
                        } catch (Exception e) {
                            logger.severe("Error listing classrooms: " + e.getMessage());
                            System.out.println("Error listing classrooms: " + e.getMessage());
                        }
                        break;
                    case "add_student":
                        try {
                            studentid = sc.nextInt();
                            Classname = sc.next();
                            if (classes.containsKey(Classname)) {
                                classes.get(Classname).addStudent(studentid);
                            } else {
                                logger.warning("Classroom " + Classname + " does not exist.");
                                System.out.println("Classroom " + Classname + " does not exist.");
                            }
                        } catch (Exception e) {
                            logger.severe("Error adding student: " + e.getMessage());
                            System.out.println("Wrong data type");
                        }
                        break;
                    case "list_students":
                        try {
                            Classname = sc.next();
                            if (classes.containsKey(Classname)) {
                                classes.get(Classname).displayStudents();
                            } else {
                                logger.warning("Classroom " + Classname + " does not exist.");
                                System.out.println("Classroom " + Classname + " does not exist.");
                            }
                        } catch (Exception e) {
                            logger.severe("Error listing students: " + e.getMessage());
                            System.out.println("Error listing students: " + e.getMessage());
                        }
                        break;
                    case "schedule_assignment":
                        try {
                            Classname = sc.next();
                            AssignmentName = sc.next();
                            if (classes.containsKey(Classname)) {
                                classroom cl = classes.get(Classname);
                                cl.addAssignment(AssignmentName);
                            } else {
                                logger.warning("Classroom " + Classname + " does not exist.");
                                System.out.println("Classroom " + Classname + " does not exist.");
                            }
                        } catch (Exception e) {
                            logger.severe("Error scheduling assignment: " + e.getMessage());
                            System.out.println("Error scheduling assignment: " + e.getMessage());
                        }
                        break;
                    case "submit_assignment":
                        try {
                            // System.out.println("Enter the studentID:");
                            studentid = sc.nextInt();
                            // System.out.println("Enter the classname:");
                            Classname = sc.next();
                            // System.out.println("Enter the name of the assignment:");
                            AssignmentName = sc.next();
                            if (classes.containsKey(Classname)) {
                                classroom cl = classes.get(Classname);
                                cl.submitAssignment(AssignmentName, studentid);
                            } else {
                                logger.warning("Classroom " + Classname + " does not exist.");
                                System.out.println("Classroom " + Classname + " does not exist.");
                            }

                        } catch (Exception e) {
                            logger.severe("Error submitting assignment: " + e.getMessage());
                            System.out.println("Error submitting assignment: " + e.getMessage());
                        }
                        break;
                    case "display_assignment_status":
                        try {
                            // System.out.println("Enter the classname:");
                            Classname = sc.next();
                            // System.out.println("Enter the name of the assignment:");
                            AssignmentName = sc.next();

                            if (classes.containsKey(Classname)) {
                                classroom cl = classes.get(Classname);
                                cl.displayAssignmentStatus(AssignmentName);
                            } else {
                                logger.warning("Classroom " + Classname + " does not exist.");
                                System.out.println("Classroom " + Classname + " does not exist.");
                            }

                        } catch (Exception e) {
                            logger.severe("Error displaying assignment status: " + e.getMessage());
                            System.out.println("Error displaying assignment status: " + e.getMessage());
                        }
                        break;

                    default:
                        logger.warning("Invalid choice.");
                        System.out.println("Invalid choice");
                        k = 0;
                        break;
                }
            } catch (Exception e) {
                logger.severe("An error occurred: " + e.getMessage());
                System.out.println("An error occurred: " + e.getMessage());
                k = 0;
            }
            System.out.println("==================================");
        }
        sc.close();
    }
}