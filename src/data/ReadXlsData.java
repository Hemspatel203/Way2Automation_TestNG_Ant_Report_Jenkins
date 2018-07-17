package data;

public class ReadXlsData {


		public static Xls_Reader xlsReader = new Xls_Reader("data.xlsx");
		
		public static String browser = xlsReader.getCellData("Config", "browser", 2);
		public static String siteName = xlsReader.getCellData("Config", "sitename", 2);

		public static String userName = xlsReader.getCellData("Data1", "UserName", 2);
		public static String passWord = xlsReader.getCellData("Data1", "Password", 2);
		
		public static String name = xlsReader.getCellData("Register","name", 2);
		public static String phone = xlsReader.getCellData("Register", "phone", 2).toString();
		public static String email = xlsReader.getCellData("Register","email", 2);
		public static String country = xlsReader.getCellData("Register", "country", 2);
		public static String city = xlsReader.getCellData("Register", "city", 2);
		public static String uname = xlsReader.getCellData("Register", "username", 2);
		public static String pass = xlsReader.getCellData("Register", "password", 2);

		

}
