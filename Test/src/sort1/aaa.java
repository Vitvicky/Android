package sort1;

import jmetal.qualityIndicator.entropy;

public class aaa {

	 

}





/*
* definitions of final value used in AdaptiveGrid
*/
numberOfViolatedConstraints_ = solution.getNumberOfViolatedConstraint();
numberOfViolatedConstraints =solution.numberOfViolatedConstraints_();
bisections_= (numberOfViolatedConstraints+numberOfObjectives)*k;

/**
* This class can be invoqued from the command line. Two params are required:
* 1) the name of the file containing the front, and 2) the name of the file 
* containig the true Pareto front
**/



//obtain the maximum of the array
int index;
for(index=1;index<cth.length;index++)
if(cth[index]>max)
max=cth[index];

//STEP 6.adapt AdaptiveGrid to ParetoFront

//define the position of hypercube
double[] wk=new double[numberOfObjectives];
wk=(maximumValue - minimumValue)/bisections_;
double[] lowerk=new double[numberOfObjectives];
lowerk=minimumValue;
double[] upperk=new double[numberOfObjectives];
upperk=maximumValue;
int[] f1size=new int[bisections_];
fisize[fisize.index-1]=fisize.index;
double[] rupperbound=new double[numberOfObjectives];
double[] lowerbound=new double[numberOfObjectives];
rupperbound=(lowerk+f1size/bisections_)*(upperk-lowerk)*wk;
lowerbound=(lowerk+(f1size-1)/bisections_)*(upperk-lowerk)*wk;

//judge whether the Front is in the hypercube or not 
double[] aFront=new double[numberOfObjectives];
for(int i;i<numberOfObjectives;i++){
if((FrontValue[i]>=lowerbound[i])
|| (FrontValue[i]<rupperbound[i]))
aFront[i]=FrontValue[i];
}
double[]bFront=new double[numberOfObjectives];
bFront=aFront.arraycopy();



// step 7.Get the distance between the Frontvalues
double distanceFront =0.0;
double tan;
double density;
double sundens;
double value;
for (int t = 0; t < aFront.length; t++){
for (int t = 0; t < bFront.length; t++) 
distanceFront=utils_.distance(aFront, bFront);
tan=-Math.pow(distanceFront/max,2)/2;
density+=1/max/Math.pow(2*3.1415926535,0.5)*Math.exp(tan);
}
sundens+=density;
double posfunc=density/sundens;
value+=posfunc*Math.log(posfunc);
double EntropyValue=-value;

System.out.println(value); 
}
