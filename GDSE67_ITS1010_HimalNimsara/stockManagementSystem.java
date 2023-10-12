import java.util.*;
class stockManagementSystem {
    private static final void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
        }
    }
    static Scanner input = new Scanner(System.in);
    static String[] cred = { "himal", "2133" };
    static String [][] suppliers = {};
    static String [] addItemCategory = {};
    static String[][] addItemDetails01 = new String[0][4];
	static double[][] addItemDetails02 = new double[0][2];
	static String[][] tempItemDetail1 = new String[4][0];
	static double[][] tempItemDetail2 = new double[2][0];
    
    public static void loginPage() {
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                              LOGIN PAGE                               |");
        System.out.println("+-----------------------------------------------------------------------+");
              
        while (true) {
            System.out.println();
        
            System.out.print("Enter the user name: ");
            String userName = input.next();

            boolean isMatched = checkUserNameValidity(cred, userName);
            if (isMatched) {
                System.out.println();
                while (true) {
                    System.out.print("Enter the password: ");
                    String pw = input.next();

                    boolean isCorrected = checkPw(cred, pw);
                    if (isCorrected) {
                        //homeHead();
                        optionList();
                        break;
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                    }
                }
                break;
            } else {
                System.out.println("Invalid username. Please try again.");
            }
        }
    }

    public static boolean checkUserNameValidity(String[] cred, String userName) {
        return cred[0].equals(userName);
    }
    public static boolean checkPw(String[] cred, String pw) {
        return cred[1].equals(pw);
    }

	public static void optionList(){
		clearConsole();
		
		System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                   WELCOME TO IJSE STOCK MANAGEMENT SYSTEM             |");
        System.out.println("+-----------------------------------------------------------------------+");
		
		System.out.print("[1] Change the Credenials\t\t");
		System.out.println("[2] Supplier Manage");
		System.out.print("[3] Stock Manage\t\t\t");
		System.out.println("[4] Log out");
		System.out.println("[5] Exit the System");
		
		System.out.println();
		System.out.print("Enter an option number to continue > ");
		int opNo=input.nextInt();
	
		switch(opNo) {
			case 1:
				changeCredential();
				break;
			case 2:
				supplierManager();
				break;
			case 3:
				stockManager();
				break;
			case 4:
				logOut();
			default:
				exit();
		}
	}
	public static void changeCredential(){
		clearConsole();
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                   Change Credentials 					|");
        System.out.println("+-----------------------------------------------------------------------+");
        
        while (true) {
            System.out.println();
        
            System.out.print("Enter the user name to veryfy it's you: ");
            String userName = input.next();

            boolean isMatched = checkUserNameValidity(cred, userName);
            if (isMatched) {
                System.out.println();
                System.out.println("hey "+userName);
                while (true) {
                    System.out.print("Enter the password: ");
                    String pw = input.next();

                    boolean isCorrected = checkPw(cred, pw);
                    if (isCorrected) {
                        changepw();
                        break;
                    } else {
                        System.out.println("Incorrect password. Please try again.");
                    }
                }
                break;
            } else {
                System.out.println("Invalid username. Please try again.");
            }
        }	
	}
	public static void changepw(){            
		System.out.print("Enter the new Password: ");
		cred[1] = input.next();
		
		System.out.print("Password changed successfully ! Do you want to go home page(Y/N) : ");
		char op = input.next().charAt(0);
		if(op=='Y'|| op=='y') {
			clearConsole();
			optionList();
		}else if(op=='N'|| op=='n') {
			clearConsole();
			optionList();
		}
	}
	public static void logOut(){
		clearConsole();
		loginPage();
		
	}
	public static void exit(){
		System.exit(0);
	}
	public static void supplierManager(){
        clearConsole();
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                   Supplier Manage  	     				|");
        System.out.println("+-----------------------------------------------------------------------+");
        
        System.out.print("[1] Add Supplier");
        System.out.println("\t\t[2] Update Supplier");
        System.out.print("[3] Delete Supplier");
        System.out.println("\t\t[4] View Supplier");
        System.out.print("[5] Serach Supplier");
        System.out.println("\t\t[6} Home Page");
 
		System.out.println();
		System.out.print("Enter an option number to continue > ");
		int suOpNo=input.nextInt();
 
 		switch(suOpNo) {
			case 1:
				addSupplier();
				break;
			case 2:
				updateSupplier();
				break;
			case 3:
				deleteSupplier();
				break;
			case 4:
				viewSupplier();
				break;
			case 5:
				searchSupplier();
			default:
                optionList();
		}
	}
	public static String [][] grow(String [][] suppliers){
		String [][] temp = new String [suppliers.length + 1][2];
			for (int i = 0; i < suppliers.length; i++){
				temp[i] = suppliers[i];
			}
			return temp;
	}
	public static void addSupplier() {
      clearConsole();
      System.out.println("+-----------------------------------------------------------------------+");
      System.out.println("|                             ADD SUPPLIER                              |");
      System.out.println("+-----------------------------------------------------------------------+");
	  
		L1:
		do{
			System.out.print("Supplier Id : ");
			String id = input.next();
			
			for (int i = 0; i < suppliers.length; i++){
				if (id.equals(suppliers[i][0])){
					System.out.println("Id alredy exists. try another supplier Id!\n");
					continue L1;
				}
			}
			System.out.print("Supplier Name : ");
			String name = input.next();
			
			suppliers = grow(suppliers);
			suppliers [suppliers.length -1] [0] = id;
			suppliers [suppliers.length - 1] [1] = name;
			System.out.println();
			System.out.println("Supplier added successfully!");
			
			System.out.print("Do you want to add another supplier (Y/N): ");
            char op = input.next().charAt(0);
            
                 if (op == 'N' || op == 'n'){
					clearConsole();
					supplierManager();
				}
		} while (true); 
    }

	public static void updateSupplier(){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           UPDATE SUPPLIER                                |");
		System.out.println("+--------------------------------------------------------------------------+");
		
		boolean supplierFound = false;
		L1:
		do {
			System.out.print("Supplier Id: ");
			String id = input.next();
			supplierFound = false;

			for (int i = 0; i < suppliers.length; i++) {
				if (id.equals(suppliers[i][0])) {
					supplierFound = true;
					System.out.println("Supplier name: " + suppliers[i][1]);
					System.out.print("Enter a new supplier name: ");
					String newName = input.next();
					suppliers[i][1] = newName;
				}
			}
			if (!supplierFound) {
				System.out.println("can't find supplier. Please try again!");
				continue L1;
			}
			System.out.print("Do you want to update another supplier (Y/N): ");
			char op = input.next().charAt(0);
			if (op == 'N' || op == 'n') {
				clearConsole();
				supplierManager();
				return;
			}
		} while (true);
	}
	    
	public static void deleteSupplier(){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           DELETE SUPPLIER                                |");
		System.out.println("+--------------------------------------------------------------------------+");

		boolean supplierFound = false;
		L1:
		do {
			System.out.print("Supplier Id: ");
			String id = input.next();
			supplierFound = false;

			for (int i = 0; i < suppliers.length; i++) {
				if (id.equals(suppliers[i][0])) {
					supplierFound = true;
					String[][] temp = new String[suppliers.length - 1][suppliers[0].length];
					
                int k = 0;
                for (int j = 0; j < suppliers.length; j++) {
                    if (j != i) {
                        temp[k++] = suppliers[j];
                    }
                }
					suppliers = temp;
					System.out.println("Supplier deleted successfully!");
					break;
				}
			}
			if (!supplierFound) {
				System.out.println("can't find supplier. Please try again!");
				continue L1;
			}
			System.out.print("Do you want to delete another supplier (Y/N): ");
			char op = input.next().charAt(0);
			if (op == 'N' || op == 'n') {
				clearConsole();
				supplierManager();
				return;
			}
		} while (true);
	}	
	
	public static void viewSupplier(){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           VIEW SUPPLIER                                  |");
		System.out.println("+--------------------------------------------------------------------------+");
		
		System.out.println();
		System.out.println("+-----------------------+-------------------------+");
		System.out.println("|    SUPPLIER ID        |    SUPPLIER NAME        |");
		System.out.println("+-----------------------+-------------------------+");
		
		for (int i = 0; i < suppliers.length; i++){
			System.out.print("|");
			for (int j = 0; j < suppliers[i].length; j++){
				System.out.print("\t" + suppliers[i][j] + "\t\t");
				System.out.print("|\b");
			}
			System.out.println("  |");
		}
		System.out.println("+-----------------------+-------------------------+");
        while (true) {
            System.out.print("Do you want to go back to the supplier manage page (Y/N): ");
            char op = input.next().charAt(0);
            if (op == 'Y' || op == 'y') {
				clearConsole();
				supplierManager();
                return;
            } else if (op == 'N' || op == 'n') {
                exit();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
	}
		
	
	public static void searchSupplier(){
		boolean supplierFound = false;
		L1:
		do {
			System.out.print("Supplier Id: ");
			String id = input.next();
			supplierFound = false;

			for (int i = 0; i < suppliers.length; i++) {
				if (id.equals(suppliers[i][0])) {
					supplierFound = true;
					System.out.println("Supplier name: " + suppliers[i][1]);
				}
			}
			if (!supplierFound) {
				System.out.println("can't find supplier id. Please try again!");
				continue L1;
			}
			System.out.print("Do you want to add another find (Y/N): ");
			char op = input.next().charAt(0);
			if (op == 'Y' || op == 'y') {
				System.out.println("");
				continue L1;
			}
			if (op == 'N' || op == 'n') {
				clearConsole();
				supplierManager();
				return;
			}
		} while (true);				
	}
	
	public static void stockManager(){
        clearConsole();
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                   Stock Manage             				|");
        System.out.println("+-----------------------------------------------------------------------+");	
        
        System.out.print("[1] Manage Item Categories");
        System.out.println("\t[2] Add Item");
        System.out.print("[3] Get Items Supplier Wise");
        System.out.println("\t[4] View Items");
        System.out.print("[5] Rank Items per unit price");
        System.out.println("\t[6] Home Page");
        
        System.out.println("");
		System.out.print("Enter an option number to continue: ");
		int smNo=input.nextInt();
 
 		switch(smNo) {
			case 1:
				manageItemCategories();
				break;
			case 2:
				addItems();
				break;
			case 3:
				getItemSupplierWise();
				break;
			case 4:
				viewItems();
				break;
			case 5:
				rankItemsByUnitPrice();
				break;
			default:
                optionList();
		}
	}
    public static void manageItemCategories(){
		clearConsole();
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                   Manage Item Category             			|");
        System.out.println("+-----------------------------------------------------------------------+");
        
        System.out.print("[1] Add New Item Category");
        System.out.println("\t[2] Delete Item Category");
        System.out.print("[3] Update Item Category");
        System.out.println("\t[4] Stock Manage");
        
        System.out.println();
		System.out.print("Enter an option number to continue: ");
		int mICNo=input.nextInt();
		
 		switch(mICNo) {
			case 1:
				addNewItemCategory();
				break;
			case 2:
				deleteItemCategory();
				break;
			case 3:
				updateItemCatogory();
				break;
			case 4:
				stockManager();
			default:
                System.out.println("Invalid input!!!Please try again...");
		}		  
	}
	
	public static String []growItem(String [] addItemCategory){
		String [] temp = new String [addItemCategory.length + 1];
			for (int i = 0; i < addItemCategory.length; i++){
				temp[i] = addItemCategory[i];
			}
			return temp;
	}
	
	public static void addNewItemCategory(){
		clearConsole();
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                   	Add Item Catrgory             			|");
        System.out.println("+-----------------------------------------------------------------------+");
		
		System.out.println();
		boolean categoryFound = false;
		L1:
		do{
			System.out.println();
			System.out.print("Enter the new Item Category: ");
			String catag = input.next();
			categoryFound = false;
			
			for (int i = 0; i < addItemCategory.length; i++){
				if (catag.equals(addItemCategory[i])){
					System.out.println("Category alredy exists. try another category.\n");
					continue L1;
				}
			}
			addItemCategory=growItem(addItemCategory);
			addItemCategory[addItemCategory.length-1]=catag;
			
			System.out.print("Added Successfuly!Do you want to add another category (Y/N): ");
            char op = input.next().charAt(0);      
            if (op == 'N' || op == 'n') {
				clearConsole();
				manageItemCategories();
			}			
		} while (true);
	}
	public static void deleteItemCategory(){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           DELETE ITEM CATEGORY                           |");
		System.out.println("+--------------------------------------------------------------------------+");
		
		boolean categoryFound = false;
		L1: do {
			System.out.print("Enter item category: ");
			String catag = input.next();
			categoryFound = false;	
		
			for (int i = 0; i < addItemCategory.length; i++) {
				if (catag.equals(addItemCategory[i])) {
					categoryFound = true;
					String[] temp = new String[addItemCategory.length - 1];

					int k = 0;
					for (int j = 0; j < addItemCategory.length; j++) {
						if (j != i) {
							temp[k++] = addItemCategory[j];
						}
					}
					addItemCategory = temp;
					System.out.println("Category deleted successfully!");
					break;
				}
			}
			if (!categoryFound) {
				System.out.println("Can't find category. Please try again!");
				continue L1;
			}
			System.out.print("Do you want to delete another category (Y/N): ");
			char op = input.next().charAt(0);
			if (op == 'N' || op == 'n') {
				clearConsole();
				manageItemCategories();
				return;
			}
		} while (true);
	}
	
	public static void updateItemCatogory(){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           UPDATE ITEM CATOGORY                           |");
		System.out.println("+--------------------------------------------------------------------------+");

		boolean categoryFound = false;
		L1:
		do {
			System.out.print("Enter a Catogory to Update: ");
			String catag = input.next();
			categoryFound = false;

			for (int i = 0; i < addItemCategory.length; i++) {
				if (catag.equals(addItemCategory[i])) {
					categoryFound = true;
					System.out.print("Enter a new category name: ");
					String newName = input.next();
					addItemCategory[i] = newName;
				}
			}
			if (!categoryFound) {
				System.out.println("can't find category. Please try again!");
				continue L1;
			}
			System.out.print("Do you want to update another category (Y/N): ");
			char op = input.next().charAt(0);
			if (op == 'N' || op == 'n') {
                clearConsole();
				manageItemCategories();
				return;
			}
		} while(true);
	}
	public static String[][] growItemDetails01(String[][] addItemDetails01) {
		String[][] temp = new String[addItemDetails01.length + 1][4];
		for (int i = 0; i < addItemDetails01.length; i++) {
			for (int j = 0; j < addItemDetails01[i].length; j++) {
				temp[i][j] = addItemDetails01[i][j];
			}
		}
		return temp;
	}
	public static double[][] growItemDetails02(double[][] addItemDetails02) {
		double[][] temp = new double[addItemDetails02.length + 1][2];
		for (int i = 0; i < addItemDetails02.length; i++) {
			for (int j = 0; j < addItemDetails02[i].length; j++) {
				temp[i][j] = addItemDetails02[i][j];
			}
		}
		return temp;
	}
	
	public static void addItems(){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           Add Item                           		   |");
		System.out.println("+--------------------------------------------------------------------------+");
		
		if (addItemCategory.length == 0) {
			System.out.println("Oops! It seems like you don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category? (Y/N): ");
			char op = input.next().charAt(0);

			if (op == 'Y' || op == 'y') {
				clearConsole();
				manageItemCategories();
			} else {
				exit();
			}
		}
		if (suppliers.length == 0) {
			System.out.println("Oops! It seems like you don't have any suppliers in the system.");
			System.out.print("Do you want to add a new supplier? (Y/N): ");
			char op = input.next().charAt(0);

			if (op == 'Y' || op == 'y') {
				clearConsole();
				addSupplier();
			} else {
				exit();
			}
		}
		L1:
		do {
			System.out.print("Item code: ");
			String itemCode = input.next();
				for (int i = 0; i < addItemDetails01.length; i++) {
					if (itemCode.equals(addItemDetails01[i][0])) {
						System.out.println("Item Code already exists. Try another Item Code.");
					continue L1;
				}
			}
			System.out.println();
			System.out.println("Supplier list:");

			System.out.println("+-----------------------+-----------------------+-------------------------+");
			System.out.println("|          #            |    SUPPLIER ID        |    SUPPLIER NAME        |");
			System.out.println("+-----------------------+-----------------------+-------------------------+");

			int rCount1 = 1;
			for (int i = 0; i < suppliers.length; i++) {
				System.out.print("|");
				System.out.print("\t" + rCount1 + "\t\t|");
				for (int j = 0; j < suppliers[i].length; j++) {
					System.out.print("\t" + suppliers[i][j] + "\t\t");
					System.out.print("|\b");
				}
				System.out.println("  |");
				rCount1++;
			}
			System.out.println("+-----------------------+-----------------------+-------------------------+");

			System.out.print("Enter the supplier number > ");
			rCount1 = input.nextInt();

			System.out.println();
			System.out.println("Item Categories:");
			System.out.println("+-----------------------+-------------------------+");
			System.out.println("|           #           |      CATEGORY NAME      |");
			System.out.println("+-----------------------+-------------------------+");

			int rCount2 = 1;
			for (int i = 0; i < addItemCategory.length; i++) {
				System.out.print("|");
				System.out.print("\t" + rCount2 + "\t\t|");
				System.out.print("\t" + addItemCategory[i] + "\t\t");
				System.out.println("  |");
				rCount2++;
			}
			System.out.println("+-----------------------+-------------------------+");

			System.out.print("Enter the category number > ");
			rCount2 = input.nextInt();

			System.out.print("Description: ");
			String description = input.next();
			System.out.print("Unit Price: ");
			double unitPrice = input.nextDouble();
			System.out.print("Qty On Hand: ");
			double qtyOnHand = input.nextDouble();

			String[][] tempItemDetail1 = new String[addItemDetails01.length + 1][4];
			for (int i = 0; i < addItemDetails01.length; i++) {
				for (int j = 0; j < addItemDetails01[i].length; j++) {
					tempItemDetail1[i][j] = addItemDetails01[i][j];
				}
			}
			tempItemDetail1[addItemDetails01.length][0] = itemCode;
			tempItemDetail1[addItemDetails01.length][1] = description;
			tempItemDetail1[addItemDetails01.length][2] = suppliers[rCount1 - 1][0];
			tempItemDetail1[addItemDetails01.length][3] = addItemCategory[rCount2 - 1];
			addItemDetails01 = tempItemDetail1;

			double[][] tempItemDetail2 = new double[addItemDetails02.length + 1][2];
			for (int i = 0; i < addItemDetails02.length; i++) {
				for (int j = 0; j < addItemDetails02[i].length; j++) {
					tempItemDetail2[i][j] = addItemDetails02[i][j];
				}
			}
			tempItemDetail2[addItemDetails02.length][0] = unitPrice;
			tempItemDetail2[addItemDetails02.length][1] = qtyOnHand;
			addItemDetails02 = tempItemDetail2;

			System.out.println("Item Added Successfully!");
			System.out.print("Do you want to add another item? (Y/N): ");
			char op = input.next().charAt(0);
			if (op == 'N' || op == 'n') {
				clearConsole();
				stockManager();
			} else {
				addItems();
			}
		} while (true);
	}
	public static void getItemSupplierWise(){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           SEARCH SUPPLIER                                |");
		System.out.println("+--------------------------------------------------------------------------+");
		
		if (suppliers.length == 0){
			System.out.println("Oops! It seems like you don't have any suppliers in the system.");
			System.out.print("Do you want to add a new supplier? (Y/N): ");
			char op = input.next().charAt(0);

			if (op == 'Y' || op == 'y') {
				clearConsole();
				addSupplier();
			} else {
				exit();
			}
		} else {
			boolean supplierFound = false;
			L1: 
			do {
				System.out.print("Supplier Id: ");
				String id = input.next();
				supplierFound = false;

				for (int i = 0; i < suppliers.length; i++) {
					if (id.equals(suppliers[i][0])) {
						supplierFound = true;
						System.out.println("Supplier name: " + suppliers[i][1]);			

						System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
						System.out.println("|    ITEM CODE    |   DESCRIPTION   |    UNIT PRICE   |   QTY ON HAND   |     CATEGORY    |");
						System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");

						for (int k = 0; k < addItemDetails01.length; k++) {
							if (id.equals(addItemDetails01[k][2])) {
								System.out.print("|");
								System.out.print("\t" + addItemDetails01[k][0] + "\t\t " + addItemDetails01[k][1] + "\t\t   " + addItemDetails02[k][0] + "\t\t " + addItemDetails02[k][1] + "\t\t  " + addItemDetails01[k][3] + "\t   ");
								System.out.println("|");
							}
						}
						System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
						break L1;
					}
				}
				if (!supplierFound) {
					System.out.println("Invalid Supplier ID. Please try again.");
				}
			} while (true);
			System.out.print("Do you want to search a new supplier? (Y/N): ");
			char op = input.next().charAt(0);

			if (op == 'Y' || op == 'y') {
			clearConsole();
			getItemSupplierWise();
			}else if(op == 'N' || op == 'n'){
			clearConsole();
			stockManager();
	
			}	
		}
	}
		
	public static void viewItems(){
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           VIEW ITEM                                      |");
		System.out.println("+--------------------------------------------------------------------------+");		
		
		for (int i = 0; i < addItemCategory.length; i++){
			System.out.println("\n\n" + addItemCategory[i] + ":");
			System.out.println("+---------------+---------------+---------------+---------------+---------------+");
			System.out.println("|     SID       |     CODE      |      DESC     |      PRICE    |      QTY      |");
			System.out.println("+---------------+---------------+---------------+---------------+---------------+");
				for (int j = 0; j < addItemDetails01.length ; j++){
					if (addItemCategory[i].equals(addItemDetails01[j][3])){
						System.out.println("\t" + addItemDetails01[j][2] + "\t\t" + addItemDetails01[j][0] + "\t\t" + addItemDetails01[j][1] + "\t\t" + addItemDetails02[j][0] + "\t\t" + addItemDetails02[j][1] + "\t");
					}
				}
			System.out.println("+---------------+---------------+---------------+---------------+---------------+");
		}
			System.out.print("Do you want to go back to the stock manage? (Y/N): ");
			char op = input.next().charAt(0);

			if (op == 'Y' || op == 'y') {
				clearConsole();
				stockManager();
				getItemSupplierWise();
			}else if(op == 'N' || op == 'n'){
				exit();
			}	
	}
	public static void sortFromPrice() {
		int itemCount = addItemDetails01.length;

		String[][] tempItemDetail1 = new String[itemCount][4];
		double[][] tempItemDetail2 = new double[itemCount][2];

		for (int i = 0; i < itemCount; i++) {
			tempItemDetail1[i][0] = addItemDetails01[i][0];
			tempItemDetail1[i][1] = addItemDetails01[i][1];
			tempItemDetail1[i][2] = addItemDetails01[i][2];
			tempItemDetail1[i][3] = addItemDetails01[i][3];

			tempItemDetail2[i][0] = addItemDetails02[i][0];
			tempItemDetail2[i][1] = addItemDetails02[i][1];
		}
		for (int i = 0; i < itemCount - 1; i++) {
			for (int j = 0; j < itemCount - i - 1; j++) {
				if (tempItemDetail2[j][0] > tempItemDetail2[j + 1][0]) {
					// Swap prices in tempItemDetail02
					double tempPrice = tempItemDetail2[j][0];
					tempItemDetail2[j][0] = tempItemDetail2[j + 1][0];
					tempItemDetail2[j + 1][0] = tempPrice;

					// Swap corresponding details in tempItemDetail01
					String[] tempDetails = tempItemDetail1[j];
					tempItemDetail1[j] = tempItemDetail1[j + 1];
					tempItemDetail1[j + 1] = tempDetails;
				}
			}
		}
		addItemDetails01 = tempItemDetail1;
		addItemDetails02 = tempItemDetail2;
	}
	public static void rankItemsByUnitPrice() {
		clearConsole();
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                           RANKED UNIT PRICE                              |");
		System.out.println("+--------------------------------------------------------------------------+");

		sortFromPrice();
		System.out.println("+-----------------+------------+------------------+-------------+-----------------+-------------------+");
		System.out.printf("|     %4s        |  %-8s  |   %-15s|   %-10s|     %-12s|    %-15s|\n","SID","CODE","DESC","PRICE","QTY","CAT");
		System.out.println("+-----------------+------------+------------------+-------------+-----------------+-------------------+");
			
		for (int i = 0; i < addItemDetails01.length; i++) {
			System.out.printf("|     %4s        |  %-8s  |   %-15s|   %-10s|     %-12s|    %-15s|\n",addItemDetails01[i][2],addItemDetails01[i][0], addItemDetails01[i][1],addItemDetails02[i][0], addItemDetails02[i][1], addItemDetails01[i][3]);
		}
			System.out.println("+-----------------+------------+------------------+-------------+-----------------+-------------------+");
		System.out.println();
		System.out.print("Do you want to go back to the stock manage Page? (Y/N): ");
		char op = input.next().charAt(0);
		if (op == 'Y' || op == 'y') {
			clearConsole();
			stockManager();
		}else if(op == 'N' || op == 'n'){
			exit();	
		}	
	}
    public static void main(String args[]) {
        loginPage();
    }
}
