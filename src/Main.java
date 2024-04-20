public class Main {
    public static void main(String[] args) {
        DeathCauseStatistic deathCauseStatistic =
                DeathCauseStatistic.fromCsvLine("A04.7          ,758,-,-,-,-,-,1,-,1,3,5,9,12,30,58,64,94,161,192,95,33");
        System.out.println(deathCauseStatistic.getAgeBracketDeaths(45));

//        DeathCauseStatisticList deathCauseStatisticList = new DeathCauseStatisticList();
//        deathCauseStatisticList.repopulate("zgony.csv");
//        System.out.println(deathCauseStatisticList.mostDeadlyDiseases(3,5));

//        ICDCodeTabular icdCodeTabular = new ICDCodeTabularOptimizedForMemory();
//        System.out.println(icdCodeTabular.getDescription("A01.0"));
    }
}