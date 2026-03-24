import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HotelReservation {
    private static final String url="jdbc:mysql://localhost:3306/hotel_db";
    private static final String user_name="root";
    private static final String password="Tushar@123";

    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,user_name,password);
            while(true){
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYATEM");
                Scanner sc=new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservation");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservation ");
                System.out.println("5. Delete Reservation");
                System.out.println("0. Exit");
                int choice=sc.nextInt();
                switch(choice){
                    case 1:
                        reserveRoom(con,sc);
                        break;
                    case 2:
                        viewReservation(con);
                        break;
                    case 3:
                        getRoom(con,sc);
                        break;
                    case 4:
                        updateReservation(con,sc);
                        break;
                    case 5:
                        deleteReservation(con,sc);
                        break;
                    case 0:
                        exit();
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    private static void reserveRoom(Connection con,Scanner sc){
        try{
            System.out.println("Enter Guest name");
            String guestName=sc.next();
            scanner.nextLine();
            System.out.println("Enter Room Number");
            int roomNumber=sc.nextInt();
            System.out.println("Enter contact Number");
            String contactNumber =Sc.next();

            String sql="Insert into reservation(guestName,roomNumber ,contact_number)"+"Values('"+guestName+"',"+ roomNumber"',"+contactNumber+"')";
            try(Statement stm=con.createStatement()){
                int rows=stm.executeUpdate(sql);
                if (rows > 0) {
                    System.out.println(" Reservation Successful");

                }
                else {
                    System.out.println("Reservatin failed");
                }
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

}


