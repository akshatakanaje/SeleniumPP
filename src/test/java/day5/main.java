package day5;

public class main {

    public static void main(String[] args) {

        customer customer = new customer();

        customer.invokeBrowser();

        customer.loginToApplication("mngr291233", "hEnYhuv");

        String titleOFThePage = customer.getTitle();

		/*System.out.println("Title of the page - "+ titleOFThePage);

		customer.addCustomer();

		String customerId = guru.getCutomerId();

		System.out.println("Customer Id - "+ customerId);

		customer.addAccount(customerId);*/

        customer.logout();

        customer.closeBrowser();
    }
}

