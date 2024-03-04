
```java
private String createPiramid(int altura) {
        String piramid = "";

        for (int i = 0; i < altura; i++) {
            // Adding spaces in front of numbers
            for (int j = 0; j < altura - i - 1; j++) {
                piramid += " ";
            }

            // Printing numbers
            for (int k = 0; k <= i; k++) {
                piramid += "* ";
            }

            piramid += "\n";
        }
        return piramid;

    }
``````