// Return the set of cities the customers are from
fun Shop.getCitiesCustomersAreFrom(): Set<City> = customers.map(Customer::city).toSet()

// Return a list of the customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> =
        customers.filter { customer -> customer.city.equals(city) }

/*
customers.map { it.city }.toSet()
customers.filter { it.city == city }
*/