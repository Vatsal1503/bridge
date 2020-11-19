package com.bridge.resilience.bridgeresilience.repository;

import com.bridge.resilience.bridgeresilience.model.BRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;

@Repository
public class BRICalculationRepository {

    @Autowired
    private EntityManager entitymanager;

    private static Logger logger = LoggerFactory.getLogger(BRICalculationRepository.class);
    private static DecimalFormat dbig=new DecimalFormat("#.##");
    private static DecimalFormat dbig1=new DecimalFormat("#.####");

    public double getsaveAndGenrateBRIValue(BRI thebri,String name){
        double robustness[][] = {{0.53,0.14,0.16,0.17},
                {thebri.getBridge_Vulnerability(),thebri.getPrediction_of_acute_shock_severity(),thebri.getAverage_daily_traffic(),thebri.getPreliminary_restoration_cost()},
                {1.00,1.00,1.00,1.00},
                {0.00,0.00,0.00,0.00}};
        double rapidity[][] = {{0.11,0.34,0.45,0.10},
                {thebri.getRestoration_time(),thebri.getDisaster_management(),thebri.getArea_or_region_affected(),thebri.getDuration_for_Procuring_and_Tendering()},
                {1.00,1.00,1.00,1.00},
                {0.00,0.00,0.00,0.00}};
        double resourcefulness[][] = {{0.26,0.18,0.10,0.46},
                {thebri.getInspection_technique(),thebri.getMaturity_in_Planning_and_scheduling(),thebri.getEmergency_response_management(),thebri.getArrangement_funds()},
                {1.00,1.00,1.00,1.00},
                {0.00,0.00,0.00,0.00}};
        double redundancy[][] = {{0.22,0.19,0.07,0.52},
                {thebri.getAvailability_of_materials_and_equipments(),thebri.getAvailability_of_backup_contractor(),thebri.getDetour_length(),thebri.getAvailability_of_fund()},
                {1.00,1.00,1.00,1.00},
                {0.00,0.00,0.00,0.00}};

        //Operation for Robustness
        String get_R_Value=getRValue(robustness);
        //logger.info("get_R_Value Value="+get_R_Value);
        double get_Normalized[][]=getNormalizedOfRij(get_R_Value,robustness);
        String sn="",sw="",sn1="",sw1="",sn2="",sw2="",sn3="",sw3="";
        for (int i = 0; i < get_Normalized.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < get_Normalized[i].length; j++)
                sn=sn+get_Normalized[i][j] + " ";
        double get_Weigthted[][]=getWeigthtedVij("0.53,0.14,0.16,0.17",get_Normalized);
        for (int i = 0; i < get_Weigthted.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < get_Weigthted[i].length; j++)
               sw=sw+get_Weigthted[i][j] + " ";
        String get_sPlus=getPositiveCloseness(get_Weigthted);
        //logger.info("get_Normalized Value="+sn);
        //logger.info("get_Weigthted Value="+sw);
        //logger.info("get_sPlus Value="+get_sPlus);
        String get_sNegative=getNegativeCloseness(get_Weigthted);
        //logger.info("get_sNegative Value="+get_sNegative);
        double dRobustness=getSubMainValue(get_sPlus.split(",")[0],get_sNegative.split(",")[0]);
        //logger.info("Robustness Value="+dRobustness);

        //Operation for Rapidity
        String get_R_Value1=getRValue(rapidity);
        //logger.info("get_R_Value1 Value="+get_R_Value1);
        double get_Normalized1[][]=getNormalizedOfRij(get_R_Value1,rapidity);
        for (int i = 0; i < get_Normalized1.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < get_Normalized1[i].length; j++)
                sn1=sn1+get_Normalized1[i][j] + " ";
        double get_Weigthted1[][]=getWeigthtedVij("0.11,0.34,0.45,0.10",get_Normalized1);
        for (int i = 0; i < get_Weigthted1.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < get_Weigthted1[i].length; j++)
                sw1=sw1+get_Weigthted1[i][j] + " ";
        String get_sPlus1=getPositiveCloseness(get_Weigthted1);
        //logger.info("get_Normalized Value="+sn1);
        //logger.info("get_Weigthted Value="+sw1);
        //logger.info("get_sPlus1 Value="+get_sPlus1);
        String get_sNegative1=getNegativeCloseness(get_Weigthted1);
        //logger.info("get_sNegative1 Value="+get_sNegative1);
        double dRapidity=getSubMainValue(get_sPlus1.split(",")[0],get_sNegative1.split(",")[0]);
        //logger.info("Rapidity Value="+dRapidity);

        //Operation for Resourcefulness
        String get_R_Value2=getRValue(resourcefulness);
        //logger.info("get_R_Value2 Value="+get_R_Value2);
        double get_Normalized2[][]=getNormalizedOfRij(get_R_Value2,resourcefulness);
        for (int i = 0; i < get_Normalized2.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < get_Normalized2[i].length; j++)
                sn2=sn2+get_Normalized2[i][j] + " ";
        double get_Weigthted2[][]=getWeigthtedVij("0.26,0.18,0.10,0.46",get_Normalized2);
        for (int i = 0; i < get_Weigthted2.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < get_Weigthted2[i].length; j++)
                sw2=sw2+get_Weigthted2[i][j] + " ";
        String get_sPlus2=getPositiveCloseness(get_Weigthted2);
        //logger.info("get_Normalized Value="+sn2);
        //logger.info("get_Weigthted Value="+sw2);
        //logger.info("get_sPlus2 Value="+get_sPlus2);
        String get_sNegative2=getNegativeCloseness(get_Weigthted2);
        //logger.info("get_sNegative2 Value="+get_sNegative2);
        double dResourcefulness=getSubMainValue(get_sPlus2.split(",")[0],get_sNegative2.split(",")[0]);
        //logger.info("Resourcefulness Value="+dResourcefulness);

        //Operation for Redundancy
        String get_R_Value3=getRValue(redundancy);
        //logger.info("get_R_Value3 Value="+get_R_Value3);
        double get_Normalized3[][]=getNormalizedOfRij(get_R_Value3,redundancy);
        for (int i = 0; i < get_Normalized3.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < get_Normalized3[i].length; j++)
                sn3=sn3+get_Normalized3[i][j] + " ";
        double get_Weigthted3[][]=getWeigthtedVij("0.22,0.19,0.07,0.52",get_Normalized3);
        for (int i = 0; i < get_Weigthted3.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < get_Weigthted3[i].length; j++)
                sw3=sw3+get_Weigthted3[i][j] + " ";
        String get_sPlus3=getPositiveCloseness(get_Weigthted3);
        //logger.info("get_Normalized Value="+sn3);
        //logger.info("get_Weigthted Value="+sw3);
        //logger.info("get_sPlus3 Value="+get_sPlus3);
        String get_sNegative3=getNegativeCloseness(get_Weigthted3);
        //logger.info("get_sNegative3 Value="+get_sNegative3);
        double dRedundancy=getSubMainValue(get_sPlus3.split(",")[0],get_sNegative3.split(",")[0]);
        //logger.info("Redundancy Value="+dRedundancy);
        //Final Calculation of BRI
        double dBRI=Double.parseDouble(dbig.format( (dRobustness*0.60)+(dRapidity*0.19)+(dResourcefulness*0.13)+(dRedundancy*0.08)));
        thebri.setBRI(dBRI);
        thebri.setBridge_name(name);
        Calendar cal = Calendar.getInstance();
        thebri.setCreateDate(new Timestamp(cal.getTimeInMillis()));
        //logger.info("Bridge Name "+ thebri.getBridge_name());
        //logger.info("Date time "+ thebri.getCreateDate());
        BRI bri=entitymanager.merge(thebri);
        return dBRI;
    }
    public String getRValue(double matrix[][]){
        String valueOfR="";
        for (int col=0;col<4;col++){
            int row=0;
            valueOfR=valueOfR+Double.parseDouble(dbig.format(Math.pow(Math.pow(matrix[row+1][col],2)
                    +Math.pow(matrix[row+2][col],2)+Math.pow(matrix[row+3][col],2), 0.5)))+",";
        }
        return valueOfR;
    }
    public double [][] getNormalizedOfRij(String valueOfR,double[][] matrix){
        String r[]=valueOfR.split(",");
        double normalized[][] =new double[3][4];
        for (int col=0;col<4;col++){
                int row=1;
                normalized[0][col]=Double.parseDouble(dbig.format(matrix[row][col]/Double.parseDouble(r[col])));
                normalized[1][col]=Double.parseDouble(dbig.format(matrix[row+1][col]/Double.parseDouble(r[col])));
                normalized[2][col]=Double.parseDouble(dbig.format(matrix[row+2][col]/Double.parseDouble(r[col])));
        }
        return normalized;
    }
    public double [][] getWeigthtedVij(String valueOfweigth,double[][] matrix){
        String w[]=valueOfweigth.split(",");
        double weigthed[][] =new double[3][4];
        for (int col=0;col<4;col++){
            int row=0;
            weigthed[0][col]=Double.parseDouble(dbig.format(matrix[row][col]*Double.parseDouble(w[col])));
            weigthed[1][col]=Double.parseDouble(dbig.format(matrix[row+1][col]*Double.parseDouble(w[col])));
            weigthed[2][col]=Double.parseDouble(dbig.format(matrix[row+2][col]*Double.parseDouble(w[col])));
            //logger.info("weigthed[0][col] Value="+weigthed[0][col]);
            //logger.info("weigthed[1][col] Value="+weigthed[1][col]);
            //logger.info("weigthed[2][col] Value="+weigthed[2][col]);
        }
        return weigthed;
    }
    public String getPositiveCloseness(double[][] matrix){
        String splus="";
        double positiveCloseness[][] =new double[3][4];
        logger.info("matrix length="+matrix.length);
        for (int col=0;col<4;col++){
            double max=matrix[0][col];
            for(int row=0;row<3;row++){
                if(matrix[row][col]>max){
                    max=matrix[row][col];
                }
            }
            int row=0;
            positiveCloseness[0][col]=Double.parseDouble(dbig1.format(Math.pow((matrix[row][col]-max),2)));
            positiveCloseness[1][col]=Double.parseDouble(dbig1.format(Math.pow((matrix[row+1][col]-max),2)));
            positiveCloseness[2][col]=Double.parseDouble(dbig1.format(Math.pow((matrix[row+2][col]-max),2)));
            logger.info("positiveCloseness[0][col] Value="+positiveCloseness[0][col]);
            logger.info("positiveCloseness[1][col] Value="+positiveCloseness[1][col]);
            logger.info("positiveCloseness[2][col] Value="+positiveCloseness[2][col]);
        }
        for (int row=0;row<positiveCloseness.length;row++){
            splus=splus+""+Double.parseDouble(dbig.format(Math.pow((positiveCloseness[row][0]+positiveCloseness[row][1]+positiveCloseness[row][2]
                    +positiveCloseness[row][3]),0.5)))+",";
        }
        return splus;
    }
    public String getNegativeCloseness(double[][] matrix){
        String snegative="";
        double NegativeCloseness[][] =new double[3][4];
        for (int col=0;col<4;col++){
            double min=matrix[0][col];
            for(int row=0;row<3;row++){
                if(matrix[row][col]<min){
                    min=matrix[row][col];
                }
            }
            int row=0;
            NegativeCloseness[0][col]=Double.parseDouble(dbig1.format(Math.pow((matrix[row][col]-min),2)));
            NegativeCloseness[1][col]=Double.parseDouble(dbig1.format(Math.pow((matrix[row+1][col]-min),2)));
            NegativeCloseness[2][col]=Double.parseDouble(dbig1.format(Math.pow((matrix[row+2][col]-min),2)));
            logger.info("NegativeCloseness[0][col] Value="+NegativeCloseness[0][col]);
            logger.info("NegativeCloseness[1][col] Value="+NegativeCloseness[1][col]);
            logger.info("NegativeCloseness[2][col] Value="+NegativeCloseness[2][col]);
        }
        for (int row=0;row<NegativeCloseness.length;row++){
            snegative=snegative+""+Double.parseDouble(dbig.format(Math.pow((NegativeCloseness[row][0]+NegativeCloseness[row][1]+NegativeCloseness[row][2]
                    +NegativeCloseness[row][3]),0.5)))+",";
        }
        return snegative;
    }
    public double getSubMainValue(String splus,String snegative){
        double submainvalue=Double.parseDouble(dbig.format(Double.parseDouble(snegative)/(Double.parseDouble(splus)+Double.parseDouble(snegative))));
        return submainvalue;
    }
}
