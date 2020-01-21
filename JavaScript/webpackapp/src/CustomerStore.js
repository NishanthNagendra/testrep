let Customer = require("./Customer").Customer;

let customers = [
  new Customer(1, "A"),
  new Customer(2, "B"),
  new Customer(3, "C")
];

export class CustomerStore {
  getCustomer(id) {
    return customers.find(c => c.id === id);
  }
}
