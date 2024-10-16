
package bill;

import java.util.Scanner;


public class Bill {

    public void addBill(){
      
        Config conf = new Config();
        
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Bill Date: ");
        String date = sc.next();
        System.out.println("Total Amount: ");
        String total = sc.next();
        System.out.println("Payment Status: ");
        String status = sc.next();
        
     
        String sql = "INSERT INTO Bill ( bill_date, total_amount, payment_status) VALUES (?, ?, ?)";
          conf.addBill (sql, date, total, status);  
      

 
      
    }
          private void viewBill() {
        String qry = "SELECT * FROM Bill";
        String[] hdrs = {"Bill ID", "Bill Date","Total Amount", "Payment Status"};
        String[] clmns = {"bill_id", "bill_date","total_amount", "payment_status"};
        Config conf = new Config();
        conf.viewBill(qry, hdrs, clmns);
    }
    
          private void updateBill(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bill ID:");
        int id = sc.nextInt();
        
        sc.nextLine(); 
        
        System.out.println("Enter the new Bill Date:");
        String date = sc.nextLine();
        
        System.out.println("Enter the new Total Amount: ");
        String total = sc.nextLine();
        
        System.out.println("Enter the new Payment Status: ");
        String status = sc.nextLine();
        
       
        
        String qry = "UPDATE Bill SET bill_date = ?, total_amount = ?, payment_status = ? WHERE bill_id = ?";
        Config conf = new Config();
        conf.updateBill(qry, date, total, status, id);
    }
    
    private void deleteBill(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bill ID to delete: ");
        int id = sc.nextInt();
        
        String sqlDelete = "Delete from Bill WHERE bill_id = ?";
        Config conf = new Config();
        conf.deleteBill(sqlDelete, id);
        
        
    }
    
   
    public static void main(String[] args) {
          String response;
        Scanner sc = new Scanner(System.in);
        Bill demo = new Bill();
        int action;
        
        do{
             System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
             System.out.println("5. EXIT");
            System.out.print("Enter Action: ");
            action = sc.nextInt();

            switch (action) {
                case 1:
                    demo.addBill();
                    break;
                case 2:
                    demo.viewBill();
                    break;
                
                case 3:
                    demo.viewBill();
                    demo.updateBill();
                    break;
                case 4:
                    demo.viewBill();
                    demo.deleteBill();
                     demo.viewBill();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default: 
                    System.out.println("Invalid action. Please Try Again");
            }
            
            System.out.println("Continue?(Yes/No): ");
            response = sc.next();
            
            
        
        }while(response.equals("yes"));
          
             System.out.println("Thank You!");
    }
    
}
