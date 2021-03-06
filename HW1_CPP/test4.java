import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
public class ipc4 {
 
    public static int[][][] disgrid = new int[][][] {
            {{0, 0},{16, 0},{32, 0},{48, 0},{64, 0},{80, 0},{96, 0},{112, 0},{128, 0},{144, 0},{160, 0},{176, 0},{192, 0},{208, 0},{224, 0},{240, 0},{256, 0}},
            {{0, 16},{16, 16},{32, 16},{48, 16},{64, 16},{79, 16},{97, 17},{114, 19},{130, 18},{146, 19},{160, 18},{176, 17},{192, 16},{208, 16},{224, 16},{240, 16},{256, 16}},
            {{0, 32},{16, 32},{33, 32},{48, 32},{67, 31},{85, 35},{103, 37},{121, 40},{136, 42},{150, 43},{162, 41},{177, 37},{192, 35},{208, 32},{224, 32},{240, 31},{256, 32}},
            {{0, 48},{16, 48},{32, 48},{51, 49},{72, 49},{94, 53},{112, 56},{128, 60},{141, 63},{154, 65},{166, 65},{178, 62},{192, 57},{206, 52},{224, 48},{240, 48},{256, 48}},
            {{0, 64},{16, 64},{34, 64},{56, 63},{80, 66},{99, 68},{116, 72},{132, 76},{144, 80},{156, 84},{167, 85},{177, 83},{190, 80},{204, 74},{222, 66},{240, 64},{256, 64}},
            {{0, 80},{16, 80},{37, 78},{63, 78},{84, 78},{103, 81},{119, 85},{132, 89},{144, 94},{154, 100},{165, 103},{176, 102},{188, 100},{203, 94},{221, 85},{240, 80},{256, 80}},
            {{0, 96},{16, 96},{41, 93},{65, 91},{86, 90},{102, 90},{118, 96},{130, 102},{141, 108},{152, 116},{161, 117},{172, 119},{184, 116},{200, 112},{217, 105},{237, 97},{256, 96}},
            {{0, 112},{18, 110},{42, 106},{65, 103},{84, 101},{100, 102},{114, 105},{127, 112},{136, 119},{145, 126},{154, 130},{167, 132},{180, 132},{196, 128},{215, 122},{237, 115},{256, 112}},
            {{0, 128},{19, 126},{41, 120},{64, 113},{81, 112},{96, 112},{109, 115},{121, 120},{129, 128},{137, 135},{148, 141},{161, 143},{174, 144},{193, 142},{213, 137},{236, 131},{256, 128}},
            {{0, 144},{18, 141},{40, 135},{60, 129},{76, 125},{90, 124},{101, 125},{113, 129},{121, 136},{131, 144},{142, 150},{156, 154},{172, 154},{190, 154},{212, 149},{236, 145},{256, 144}},
            {{0, 160},{17, 160},{38, 151},{57, 144},{72, 140},{85, 138},{96, 138},{106, 141},{115, 148},{126, 153},{138, 161},{153, 165},{169, 167},{190, 167},{214, 163},{238, 161},{256, 160}},
            {{0, 176},{16, 177},{34, 170},{53, 162},{66, 156},{81, 153},{92, 153},{102, 156},{112, 158},{124, 165},{137, 171},{153, 174},{171, 178},{192, 178},{217, 177},{240, 176},{256, 176}},
            {{0, 192},{17, 192},{33, 191},{51, 182},{66, 175},{78, 170},{90, 169},{101, 172},{113, 176},{124, 181},{139, 184},{155, 188},{174, 189},{198, 193},{221, 192},{240, 192},{256, 192}},
            {{0, 208},{16, 208},{31, 208},{49, 204},{64, 197},{80, 193},{89, 190},{101, 190},{113, 191},{128, 195},{144, 198},{161, 203},{182, 205},{204, 206},{224, 208},{240, 208},{256, 208}},
            {{0, 224},{16, 224},{32, 224},{48, 223},{63, 221},{80, 217},{92, 213},{106, 212},{119, 212},{133, 215},{150, 217},{168, 220},{189, 222},{208, 224},{223, 224},{241, 224},{256, 224}},
            {{0, 240},{16, 240},{32, 240},{48, 240},{64, 240},{80, 239},{95, 238},{110, 237},{125, 236},{142, 237},{158, 238},{175, 239},{192, 240},{208, 240},{224, 240},{240, 240},{256, 240}},
            {{0, 256},{16, 256},{32, 256},{48, 256},{64, 256},{80, 256},{96, 256},{112, 256},{128, 256},{144, 256},{160, 256},{176, 256},{192, 256},{208, 256},{224, 256},{240, 256},{256, 256}}
        };
   
        public static int[][][] grid = new int[][][] {
            {{0 , 0},{16, 0},{32,0},{48, 0},{64, 0},{80,0},{96, 0},{112, 0},{128, 0},{144, 0},{160, 0},{176, 0},{192, 0},{208, 0},{224, 0},{240, 0},{256, 0}},
            {{0 , 16},{16, 16},{32,16},{48, 16},{64, 16},{80,16},{96, 16},{112, 16},{128, 16},{144, 16},{160, 16},{176, 16},{192, 16},{208, 16},{224, 16},{240, 16},{256, 16}},
            {{0 , 32},{16, 32},{32,32},{48, 32},{64, 32},{80,32},{96, 32},{112, 32},{128, 32},{144, 32},{160, 32},{176, 32},{192, 32},{208, 32},{224, 32},{240, 32},{256, 32}},
            {{0 , 48},{16, 48},{32,48},{48, 48},{64, 48},{80,48},{96, 48},{112, 48},{128, 48},{144, 48},{160, 48},{176, 48},{192, 48},{208, 48},{224, 48},{240, 48},{256, 48}},
            {{0 , 64},{16, 64},{32,64},{48, 64},{64, 64},{80,64},{96, 64},{112, 64},{128, 64},{144, 64},{160, 64},{176, 64},{192, 64},{208, 64},{224, 64},{240, 64},{256, 64}},
            {{0 , 80},{16, 80},{32,80},{48, 80},{64, 80},{80,80},{96, 80},{112, 80},{128, 80},{144, 80},{160, 80},{176, 80},{192, 80},{208, 80},{224, 80},{240, 80},{256, 80}},
            {{0 , 96},{16, 96},{32,96},{48, 96},{64, 96},{80,96},{96, 96},{112, 96},{128, 96},{144, 96},{160, 96},{176, 96},{192, 96},{208, 96},{224, 96},{240, 96},{256, 96}},
            {{0 , 112},{16, 112},{32,112},{48, 112},{64, 112},{80,112},{96, 112},{112, 112},{128, 112},{144, 112},{160, 112},{176, 112},{192, 112},{208, 112},{224, 112},{240, 112},{256, 112}},
            {{0 , 128},{16, 128},{32,128},{48, 128},{64, 128},{80,128},{96, 128},{112, 128},{128, 128},{144, 128},{160, 128},{176, 128},{192, 128},{208, 128},{224, 128},{240, 128},{256, 128}},
            {{0 , 144},{16, 144},{32,144},{48, 144},{64, 144},{80,144},{96, 144},{112, 144},{128, 144},{144, 144},{160, 144},{176, 144},{192, 144},{208, 144},{224, 144},{240, 144},{256, 144}},
            {{0 , 160},{16, 160},{32,160},{48, 160},{64, 160},{80,160},{96, 160},{112, 160},{128, 160},{144, 160},{160, 160},{176, 160},{192, 160},{208, 160},{224, 160},{240, 160},{256, 160}},
            {{0 , 176},{16, 176},{32,176},{48, 176},{64, 176},{80,176},{96, 176},{112, 176},{128, 176},{144, 176},{160, 176},{176, 176},{192, 176},{208, 176},{224, 176},{240, 176},{256, 176}},
            {{0 , 192},{16, 192},{32,192},{48, 192},{64, 192},{80,192},{96, 192},{112, 192},{128, 192},{144, 192},{160, 192},{176, 192},{192, 192},{208, 192},{224, 192},{240, 192},{256, 192}},
            {{0 , 208},{16, 208},{32,208},{48, 208},{64, 208},{80,208},{96, 208},{112, 208},{128, 208},{144, 208},{160, 208},{176, 208},{192, 208},{208, 208},{224, 208},{240, 208},{256, 208}},
            {{0 , 224},{16, 224},{32,224},{48, 224},{64, 224},{80,224},{96, 224},{112, 224},{128, 224},{144, 224},{160, 224},{176, 224},{192, 224},{208, 224},{224, 224},{240, 224},{256, 224}},
            {{0 , 240},{16, 240},{32,240},{48, 240},{64, 240},{80,240},{96, 240},{112, 240},{128, 240},{144, 240},{160, 240},{176, 240},{192, 240},{208, 240},{224, 240},{240, 240},{256, 240}},
            {{0 , 256},{16, 256},{32,256},{48, 256},{64, 256},{80,256},{96, 256},{112, 256},{128, 256},{144, 256},{160, 256},{176, 256},{192, 256},{208, 256},{224, 256},{240, 256},{256, 256}}
        };
    public static void main(String args[]) throws IOException {  
      final BufferedInputStream stream_in1 = new BufferedInputStream(new FileInputStream("distgrid.pgm"));
      final BufferedOutputStream stream_out = new BufferedOutputStream(new FileOutputStream("disgrid_out.pgm"));
     
        try {
            next(stream_in1);
            final int row = Integer.parseInt(next(stream_in1));
            final int col = Integer.parseInt(next(stream_in1));
            Integer.parseInt(next(stream_in1));
 
            int[][] image = new int[row][col];
            int[][] image_new = new int[row][col];
 
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    final int p1 = stream_in1.read();
                    image[i][j] = p1;
                }
            }
 
            image_new = controlGrid(disgrid ,grid, image,row,col);
 
            stream_out.write("P5".getBytes());
            stream_out.write("\n".getBytes());
            stream_out.write(Integer.toString(image[0].length).getBytes());
            stream_out.write(" ".getBytes());
            stream_out.write(Integer.toString(image.length).getBytes());
            stream_out.write("\n".getBytes());
            stream_out.write(Integer.toString(255).getBytes());
            stream_out.write("\n".getBytes());
            for (int i = 0; i < image.length; ++i) {
                for (int j = 0; j < image[0].length; ++j) {
                     final int p = image_new[i][j];
                     stream_out.write(p);
                }
            }
 
        } finally {
            stream_in1.close();
            stream_out.close();
        }
   }
 
   private static String next(final InputStream stream) throws IOException {
      final List<Byte> bytes = new ArrayList<Byte>();
      while (true) {
          final int b = stream.read();
 
          if (b != -1) {
 
              final char c = (char) b;
              if (c == '#') {
                  int d;
                  do {
                      d = stream.read();
                  } while (d != -1 && d != '\n' && d != '\r');
              } else if (!Character.isWhitespace(c)) {
                  bytes.add((byte) b);
              } else if (bytes.size() > 0) {
                  break;
              }
 
          } else {
              break;
          }
        }
   
 
      final byte[] bytesArray = new byte[bytes.size()];
      for (int i = 0; i < bytesArray.length; ++i)
          bytesArray[i] = bytes.get(i);
      return new String(bytesArray);
    }
 
    public static int[][] controlGrid( int[][][] disgridXY_new ,int[][][] gridXY , int[][] pic,int row , int col) {
        int[] x_new = new int[4];
        int[] y_new = new int[4];
        double[] x = new double[4];
        double[] y = new double[4];
        double[] w = new double[8];
        double[][] xy = new double[4][4];
        double[][] inverse = new double[4][4];
        int[][] image_new = new int[row][col];
        for (int i = 0; i < gridXY.length-1; ++i) {
            for (int j = 0; j < gridXY[0].length-1; ++j) {
 
                x_new[0] = gridXY[i][j][0];
                x_new[1] = gridXY[i][j+1][0];
                x_new[2] = gridXY[i+1][j][0];
                x_new[3] = gridXY[i+1][j+1][0];

                y_new[0] = gridXY[i][j][1];
                y_new[1] = gridXY[i][j+1][1];
                y_new[2] = gridXY[i+1][j][1];
                y_new[3] = gridXY[i+1][j+1][1];

                for(int num = 0 ; num < 4 ; num++){
                    xy[num][0] = x_new[num];
                    xy[num][1] = y_new[num];
                    xy[num][2] = x_new[num]*y_new[num];
                    xy[num][3] = 1;
                }

                inverse =  invert(xy);

                x[0] = disgridXY_new[i][j][0];
                x[1] = disgridXY_new[i][j+1][0];
                x[2] = disgridXY_new[i+1][j][0];
                x[3] = disgridXY_new[i+1][j+1][0];
               
                y[0] = disgridXY_new[i][j][1];
                y[1] = disgridXY_new[i][j+1][1];
                y[2] = disgridXY_new[i+1][j][1];
                y[3] = disgridXY_new[i+1][j+1][1];
               
                w[0] = (inverse[0][0] * x[0]) + (inverse[0][1] * x[1]) + (inverse[0][2] * x[2]) + (inverse[0][3] * x[3]);
                w[1] = (inverse[1][0] * x[0]) + (inverse[1][1] * x[1]) + (inverse[1][2] * x[2]) + (inverse[1][3] * x[3]);
                w[2] = (inverse[2][0] * x[0]) + (inverse[2][1] * x[1]) + (inverse[2][2] * x[2]) + (inverse[2][3] * x[3]);
                w[3] = (inverse[3][0] * x[0]) + (inverse[3][1] * x[1]) + (inverse[3][2] * x[2]) + (inverse[3][3] * x[3]);
                w[4] = (inverse[0][0] * y[0]) + (inverse[0][1] * y[1]) + (inverse[0][2] * y[2]) + (inverse[0][3] * y[3]);
                w[5] = (inverse[1][0] * y[0]) + (inverse[1][1] * y[1]) + (inverse[1][2] * y[2]) + (inverse[1][3] * y[3]);
                w[6] = (inverse[2][0] * y[0]) + (inverse[2][1] * y[1]) + (inverse[2][2] * y[2]) + (inverse[2][3] * y[3]);
                w[7] = (inverse[3][0] * y[0]) + (inverse[3][1] * y[1]) + (inverse[3][2] * y[2]) + (inverse[3][3] * y[3]);
                
                for (int k = y_new[0]; k < y_new[2]; k++) {
                    for (int l = x_new[0]; l < x_new[1]; l++) {
                        int xp = (int)Math.round(w[0]*l + w[1]*k + w[2]*l*k + w[3]);
                        int yp = (int)Math.round(w[4]*l + w[5]*k + w[6]*l*k + w[7]);
                        image_new[k][l] = pic[yp][xp];

                    }
                }   
            }
        }
        return image_new;
    }

    public static double[][] invert(double a[][]) 
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;

        gaussian(a, index);

        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                    	    -= a[index[j]][i]*b[index[i]][k];

        for (int i=0; i<n; ++i) {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }
 
    public static void gaussian(double a[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];

        for (int i=0; i<n; ++i) 
            index[i] = i;

        for (int i=0; i<n; ++i){
            double c1 = 0;
            for (int j=0; j<n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j=0; j<n-1; ++j) {
            double pi1 = 0;
            for (int i=j; i<n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i){
                double pj = a[index[i]][j]/a[index[j]][j];
                a[index[i]][j] = pj;
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }