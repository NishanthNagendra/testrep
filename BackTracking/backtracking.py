import sys 
sys.setrecursionlimit(10**4)
def rowcheck(grid, row, element):
    for k in range(9): 
        if grid[row][k] == element: 
            return True
    return False

def colcheck(grid, col, element):
    for l in range(9):
        if grid[l][col] == element:
            return True
    return False

def gridcheck(grid, row, col, element):
    row = row - (row%3)
    col = col - (col%3)
    for i in range(3):
        for j in range(3):
            if(grid[i+row][j+col] == element): 
                return True
    return False

def emptycell(grid, rowcol):
    for i in range(9):
        for j in range(9):
            if grid[i][j] == 0:
                rowcol[0] = i
                rowcol[1] = j
                return True 
    return False

def checkcell(grid, row, col, element): 
        return not(colcheck(grid, col, element)) and not(rowcheck(grid, row, element)) and not(gridcheck(gird, row, col, num)) 


def solved(grid):
    rowcol = [0, 0]
    row = rowcol[0]
    col = rowcol[1]

    if not(emptycell(grid, rowcol)):
        return True
    
    for element in range(1,10): 
    
        if(checkcell(grid, row, col, element)):
            grid[row][col] = element 
        
        if solved(grid): 
            return True

        grid[row][col] = 0
    return False 
        

def print_grid(grid):
    for i in range(9):
        for j in range(9):
            print(str(grid[i][j]) + "   ", end = '')
            if (j+1) % 3 == 0 and (j+1) != 9:
                print("|   ", end = '')
        print()
        if (i+1) % 3 == 0 and (i+1) != 9:
            print("-----------------------------------------")

if __name__=="__main__":   
    grid=[[3,0,6,5,0,8,4,0,0], 
          [5,2,0,0,0,0,0,0,0], 
          [0,8,7,0,0,0,0,3,1], 
          [0,0,3,0,1,0,0,8,0], 
          [9,0,0,8,6,3,0,0,5], 
          [0,5,0,0,9,0,6,0,0], 
          [1,3,0,0,0,0,2,5,0], 
          [0,0,0,0,0,0,0,7,4], 
          [0,0,5,2,0,6,3,0,0]] 
    print("\n\n")
    print_grid(grid)

    print("\n\n")
    if solved(grid):
        print("\n\nThe solution\n\n")
        print_grid(grid)
    else:
        print("No solution!!")