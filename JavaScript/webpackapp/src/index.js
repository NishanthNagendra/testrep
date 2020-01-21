let CustomerStore = require("./CustomerStore").CustomerStore;

console.log("hello world!");
let cs = new CustomerStore();
console.log(cs.getCustomer(2));
