const { add, sub } = require("./arith");

describe("Testing Arithmetic Operations", () => {
  test("2 + 3 = 5", () => {
    expect(add(2, 3)).toBe(5);
  });

  test("5 - 6 = -1", () => {
    expect(sub(5, 6)).toBe(-1);
  });
});
// Both it and test can be used to test 
// describe("Testing Arithmetic Operations", () => {
//     it("2 + 3 = 5", () => {
//       expect(add(2, 3)).toBe(5);
//     });
  
//     it("5 - 6 = -1", () => {
//       expect(sub(5, 6)).toBe(-1);
//     });
//   });
