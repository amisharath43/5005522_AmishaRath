interface CustomerRepository {
    Customer findCustomerById(int id);
}

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(int id) {
        return new Customer(id, "Customer " + id);
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer getCustomerById(int id) {
        return repository.findCustomerById(id);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        Customer customer = service.getCustomerById(1);
        System.out.println("Customer Name: " + customer.getName());
    }
}
