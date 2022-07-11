package Recursion;

import java.util.*;

public class LowestCommonManager {
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return getOrgInfo(topManager , reportOne , reportTwo).lowestCommonManager;
    }
    public static OrgInfo getOrgInfo(OrgChart manager , OrgChart reportOne , OrgChart reportTwo){
        int numOfReports = 0;
        for(OrgChart directReport :manager.directReports){
            OrgInfo orgInfo = getOrgInfo(directReport , reportOne , reportTwo);
            if (orgInfo.lowestCommonManager != null){
                return orgInfo;
            }
            numOfReports += orgInfo.numOfChildrenReportsFound;
        }
        if(manager == reportOne || manager == reportTwo){
            numOfReports++;
        }
        OrgChart lowestCommonManager;
        if (numOfReports == 2) lowestCommonManager = manager;
        else lowestCommonManager = null;
        return new OrgInfo(lowestCommonManager , numOfReports);
    }

    static class OrgInfo{
        public OrgChart lowestCommonManager;
        int numOfChildrenReportsFound;

        OrgInfo(OrgChart lowestCommonManager , int numOfChildrenReportsFound){
            this.lowestCommonManager = lowestCommonManager;
            this.numOfChildrenReportsFound = numOfChildrenReportsFound;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}
