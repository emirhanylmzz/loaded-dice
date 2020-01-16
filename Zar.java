/*Hileli bir zarda zar�n herbir y�z� farkl� ihtimalle gelmektedir. zar�n herbir y�z�n�n gelme ihtimalini map olarak alan 
ve bu zar�n at�lmas�n� sim�le eden kod.
@author emirhanylmzz
*/

import java.util.*;
public class Zar {
	public static int throwADice(Map<Integer, Double> diceProbs) {
		Random generator = new Random();
		double r = generator.nextDouble();
		Map<Integer, Double> diceProbs2 = new HashMap<>();
		diceProbs2.put(1, diceProbs.get(1) / 100.);
		for(int i = 2; i <= diceProbs.size(); ++i){
			diceProbs2.put(i, diceProbs2.get(i-1) + (diceProbs.get(i) / 100.));
		}
		for(int j = 1; j <= 6; j++)
		{
			if(r <= diceProbs2.get(j))
			{
				return j;
			}
			
		}
		return 0;
	}
/*Yukar�daki metodu kullanarak 1000 defa zar at�p herbir y�zden ka�ar tane geldi�ini return eden method.*/
	public static Map<Integer, Integer> throwDiceNTimes(Map<Integer, Double> diceProbs, int n){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 1; i <= diceProbs.size(); ++i) {
			map.put(i, 0);
		}
		for(int i = 0; i < n; ++i) {
			int r = throwADice(diceProbs);
			map.put(r, map.get(r) + 1);
		}
		return map;
	}
	public static void main(String[] args) {
		Map<Integer, Double> dice = new HashMap<>();
		dice.put(1, 10.);
		dice.put(2, 25.);
		dice.put(3, 20.);
		dice.put(4, 30.);
		dice.put(5, 10.);
		dice.put(6, 5.);
		System.out.println(throwADice(dice));
		System.out.println(throwDiceNTimes(dice, 1000));
	}

}
