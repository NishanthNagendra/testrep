const { add, sub } = require("./arith");

test("2 + 3 = 5", () => {
  expect(add(2, 3)).toBe(5);
});

test("5 - 6 = -1", () => {
  expect(sub(5, 6)).toBe(-1);
});
