public class Matrix{
    private int size;
    private int[][] startMatrix = new int[size][size]; //need to change where this is initiated because you can not change a matrix once it is instantiated
    private int[][] coderMatrix = new int[size][size];
    private int[][] matrix = new int[size][size];

    public Matrix(){
     size = 0;
    }
    
    public Matrix(int s){
     size = s;
     matrix = new int[size][size];
    } //produces a square matrix with size

    public Matrix(int row, int column){
      int[][] startMatrix = new int[row][column];
    }
    
    public int getSize(){
     return size; 
    }
    
    public int getElement(int r, int c){
     return matrix[r][c]; 
    }
    
    public void setElement(int r, int c, int value){
      r = (r >= 0 && r <= size)? r:0;
      c = (c >= 0 && c <= size)? c:0;
      matrix[r][c] = value; 
    }
    
    public void print(){
      for(int i = 0; i < size; i++){
        for (int j = 0; j < size; j++){
          System.out.print(matrix[i][j]+ " ");
      }
        System.out.println();
     }
   }
    
    public Matrix add(Matrix m){
      Matrix result = new Matrix(size);
      for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
          int value = matrix[i][j] + m.matrix[i][j];
          result.setElement(i, j, value);
        }
      }
      return result;
    }
    
    public Matrix subtract(Matrix m){
     Matrix result = new Matrix(size);
     for(int i = 0; i < size; i++){
       for(int j = 0; j < size; j++){
         int value = matrix[i][j] - m.matrix[i][j];
         result.setElement(i, j, value);
       }
     }
     return result;
    }
    
    public Matrix multiply(Matrix m){
     int sum = 0;
     Matrix result = new Matrix(size);
      for(int i = 0; i < size; i++)
          {
           for(int j = 0; j < size; j++)
           {
             for(int k = 0; k < size; k++)
             {
               sum = sum + matrix[i][k] * m.matrix[k][j];
             }
             result.setElement(i, j, sum);
             sum = 0;
           }
          }
      return result;
    }
    
    public Matrix multiplyConst(int constant){
      Matrix result = new Matrix(size);
      for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
          int value = matrix[i][j] * constant;
          result.setElement(i, j, value);
        }
      }
      return result;
    }
    
    public Matrix transpose()
   {
    Matrix result = new Matrix(size);
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        int transposed = matrix[j][i];
        result.setElement(i, j, transposed);
      }
    }
    return result;
   }
    
    public int trace()
         {
          int sum = 0;
          for(int i = 0; i < size; i++)
          {
            int j = 0;
            j++;
            sum = sum + matrix[i][j];
          }
          return sum;
    }
    
    public boolean equals(Matrix m){
     boolean same = true;
      for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
          if (matrix[i][j] != m.matrix[i][j])
            same = false;
        }
      }
      return same;
    }
    
    public void copy(Matrix m){
     matrix = m.matrix; 
    }
  }