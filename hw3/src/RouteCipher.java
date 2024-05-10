public class RouteCipher {

    private int key;

    public RouteCipher(int key) { setKey(key); }

    public String toString() {
        return "RouteCipher with key: " + key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if( key == -1 || key == 0 || key == 1) {this.key = 2;}
        else {
            this.key = key;
        }
    }

    public String encrypt(String plainText) {
        char[] plainTextChars = plainText.toCharArray();
        int columns = Math.abs(key);
        int rows;
        if( plainText.length() % columns == 0) {
            rows = (int) Math.ceil((double) plainText.length() / columns);
        } else {
            rows = (int) Math.ceil((double) plainText.length() / columns);
            rows++;
        }

        char[][] grid = new char[rows][columns];

        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
        if(index < plainTextChars.length) {
                grid[row][col] = plainTextChars[index++];}
        else {
                grid[row][col] = '$';
        }
            }
        }

        StringBuilder cipherText = new StringBuilder();

        index = 0;
        int rowBegin;
        int rowEnd;
        int columnBegin;
        int columnEnd;

        //for positive key spiral:
        if (key > 0) {
            rowBegin = 0;
            rowEnd = rows - 1;
            columnBegin = 0;
            columnEnd = columns - 1;

            while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
                for (int i = rowBegin; i <= rowEnd; i++) {
                    cipherText.append(grid[i][columnBegin]) ;

                }
                columnBegin++;

                for (int i = columnBegin; i <= columnEnd; i++) {
                    cipherText.append(grid[rowEnd][i]);
                }
                rowEnd--;


                if (columnBegin <= columnEnd) {
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        cipherText.append(grid[i][columnEnd]);
                    }
                }
                columnEnd--;

                if (rowBegin <= rowEnd) {
                    for (int i = columnEnd; i >= columnBegin; i--) {
                        cipherText.append(grid[rowBegin][i]);
                    }
                }
                rowBegin++;

            }
        }
        //for negative key spiral:
        else {
            rowBegin = rows - 1;
            rowEnd = 0;
            columnBegin = columns - 1;
            columnEnd = 0;

            while (rowBegin >= rowEnd && columnBegin >= columnEnd) {
                for (int i = rowBegin; i >= rowEnd; i--) {
                    cipherText.append(grid[i][columnBegin]);
                }
                columnBegin--;

                for (int i = columnBegin; i >= columnEnd; i--) {
                    cipherText.append(grid[rowEnd][i]);
                }
                rowEnd++;

                if (columnEnd <= columnBegin) {
                    for (int i = rowEnd; i <= rowBegin; i++) {
                        cipherText.append(grid[i][columnEnd]);
                    }
                }
                columnEnd++;

                if (rowEnd <= rowBegin) {
                    for (int i = columnEnd; i <= columnBegin; i++) {
                        cipherText.append(grid[rowBegin][i]);
                    }
                }
                rowBegin--;

            }
        }
        return cipherText.toString();
    }

    public String decrypt(String cipherText) {
        int columns = Math.abs(key);
        int rows;
        if( cipherText.length() % columns == 0) {
            rows = (int) Math.ceil((double) cipherText.length() / columns);
        } else {
            rows = (int) Math.ceil((double) cipherText.length() / columns);
            rows++;
        }
        char[][] grid = new char[rows][columns];
        char[] cipherTextChars = cipherText.toCharArray();
        int index = 0;
        int rowBegin;
        int rowEnd;
        int columnBegin;
        int columnEnd;

        //for positive key spiral:
        if (key > 0) {
            rowBegin = 0;
            rowEnd = rows - 1;
            columnBegin = 0;
            columnEnd = columns - 1;

            while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
                for (int i = rowBegin; i <= rowEnd; i++) {
                    grid[i][columnBegin] = cipherTextChars[index];
                    index++;
                }
                columnBegin++;

                for (int i = columnBegin; i <= columnEnd; i++) {
                    grid[rowEnd][i] = cipherTextChars[index];
                    index++;
                }
                rowEnd--;


                if (columnBegin <= columnEnd) {
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        grid[i][columnEnd] = cipherTextChars[index];
                        index++;
                    }
                }
                columnEnd--;

                if (rowBegin <= rowEnd) {
                    for (int i = columnEnd; i >= columnBegin; i--) {
                        grid[rowBegin][i] = cipherTextChars[index];
                        index++;
                    }
                }
                rowBegin++;

            }
        }
        //for negative key spiral:
        else {
            rowBegin = rows - 1;
            rowEnd = 0;
            columnBegin = columns - 1;
            columnEnd = 0;

            while (rowBegin >= rowEnd && columnBegin >= columnEnd) {
                for (int i = rowBegin; i >= rowEnd; i--) {
                    grid[i][columnBegin] = cipherTextChars[index];
                    index++;
                }
                columnBegin--;

                for (int i = columnBegin; i >= columnEnd; i--) {
                    grid[rowEnd][i] = cipherTextChars[index];
                    index++;
                }
                rowEnd++;

                if (columnEnd <= columnBegin) {
                    for (int i = rowEnd; i <= rowBegin; i++) {
                        grid[i][columnEnd] = cipherTextChars[index];
                        index++;
                    }
                }
                columnEnd++;

                if (rowEnd <= rowBegin) {
                    for (int i = columnEnd; i <= columnBegin; i++) {
                        grid[rowBegin][i] = cipherTextChars[index];
                        index++;
                    }
                }
                rowBegin--;

            }
        }


        char[] result = new char[rows * columns];
        index = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                // setting the empty boxes to e special symbol - dollar sign
                if (grid[r][c] != '$') {
                    result[index] = grid[r][c];
                    index++;
                }
            }
        }


        return new String(result).trim();
    }



}
