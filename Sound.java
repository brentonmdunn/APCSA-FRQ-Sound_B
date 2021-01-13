/**
* Sound.java
* @author Brenton Dunn / 218005
* @author Carlos Campa / 218023
* @since 14 January 2021
* @version 1.0
*/

import java.util.Arrays;
public class Sound {
  /** the array of values in this sound; guaranteed not to be null */
  private int[] samples = {0, 0, 0, 0, 0, 0, 40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223};

  /**
  * finds values that are above or below the limit and reduces it down to the limit
  * @param  limit
  * @return number of values above or below the limit
  */
  public int limitAmplitude(int limit) {
    
    // counts number of values that go beyond the given limit
    int beyondLimit = 0;
    
    // cycles through the values in the array
    for (int i=0; i < samples.length; i++) {
      
      // if the value is above the limit, the value is set to the limit
      if (samples[i] > limit) {
        samples[i] = limit;
        beyondLimit++;
       
      // if the value is below the limit, the value is set to the -limit
      } else if (samples[i] < -limit) {
        samples[i] = -limit;
        beyondLimit++;
      }
    }
    return beyondLimit;
  }

  /**
  * deletes leading 0s in the array
  */
  public void trimSilenceFromBeginning() {
    
    // counts the number of 0s that are in front
    int zeroCount = 0;
    
    // find the length of the array without 0s
    int newLength = 0;
    
    // cycles through values in array to find where the non-0 values start
    for (int values : samples) {
        // when finds a non-0 value, exits loop
        if (values != 0) {
          break;
        }
      
    // increments zeroCount everytime a 0 is found
    zeroCount++;
    }
    
    // calculates length for new array by subtracting the number of 0s from the original array length
    newLength = samples.length - zeroCount;
    
    // declares new array
    int[] newArray = new int[newLength];
    
    // FOR loop that transfers values from the original array into the new array. Loop starts at at zeroCount, which is where the non-0 elements start
    for (int i=zeroCount; i < samples.length; i++) {
      
      // need to do i-zeroCount to start the new array at 0
      newArray[i-zeroCount] = samples[i];
    }
    
    // set the original array equal to the new array
    samples = newArray;
  }

  public static void main(String[] args) {

    Sound s = new Sound();

    System.out.println("The original array of samples is " + Arrays.toString(s.samples));
    s.trimSilenceFromBeginning();
    System.out.println("The new array of samples is " + Arrays.toString(s.samples));
    System.out.println("The length of the new array should be 14 and is " + s.samples.length);


    System.out.println("The original array is: " + Arrays.toString(s.samples));
    System.out.println("limitAmplitude(2000) should return 5 " + "and returned " + s.limitAmplitude(2000));
    System.out.println("The changed array is: " + Arrays.toString(s.samples));
    
  }
}
