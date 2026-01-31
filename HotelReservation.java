import java.sql.*;
import java.util.Scanner;

public class HotelReservation {

    static final String URL = "jdbc:mysql://localhost:3306/hotel";
    static final String USER = "root";      
    static final String PASS = "Deesa028";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotel",
                    "root",
                    "Deesa028");

            while(true){

                System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
                System.out.println("1. Reserve Room");
                System.out.println("2. View Reservations");
                System.out.println("3. Check-Out");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch(choice){

                    
                    case 1:

                        sc.nextLine(); 

                        System.out.print("Enter Guest Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Room Number: ");
                        int room = sc.nextInt();

                        PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO reservations(guest_name, room_no) VALUES (?, ?)");

                        ps.setString(1, name);
                        ps.setInt(2, room);

                        ps.executeUpdate();

                        System.out.println("Room Reserved Successfully!");
                        break;


                    
                    case 2:

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM reservations");

                        System.out.println("\nID   Guest Name   Room No");

                        while(rs.next()){
                            System.out.println(
                                    rs.getInt("id") + "     " +
                                    rs.getString("guest_name") + "     " +
                                    rs.getTimestamp("check_in") + "     " +
                                    rs.getInt("room_no"));
                        }
                        break;


                    //Check-Out (Delete)
                    case 3:

                        System.out.print("Enter Reservation ID: ");
                        int id = sc.nextInt();

                        PreparedStatement ps2 = con.prepareStatement(
                                "DELETE FROM reservations WHERE id=?");

                        ps2.setInt(1, id);

                        int rows = ps2.executeUpdate();

                        if(rows > 0)
                            System.out.println("Guest Checked-Out!");
                        else
                            System.out.println("Reservation not found.");

                        break;


                    case 4:
                        con.close();
                        System.out.println("Thank You!");
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }
}