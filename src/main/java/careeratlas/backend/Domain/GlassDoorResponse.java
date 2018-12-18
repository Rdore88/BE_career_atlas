package careeratlas.backend.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlassDoorResponse {

    private String website;
    private String squareLogo;
    private String overallRating;
    private String cultureAndValuesRating;
    private String seniorLeadershipRating;
    private String compensationAndBenefitsRating;
    private String careerOpportunitiesRating;
    private String workLifeBalanceRating;
    private String recommendToFriendRating;

    public GlassDoorResponse(@JsonProperty("website") String website,
                             @JsonProperty("squareLogo") String squareLogo,
                             @JsonProperty("overallRating") String overallRating,
                             @JsonProperty("cultureAndValuesRating") String cultureAndValuesRating,
                             @JsonProperty("seniorLeadershipRating") String seniorLeadershipRating,
                             @JsonProperty("compensationAndBenefitsRating") String compensationAndBenefitsRating,
                             @JsonProperty("careerOpportunitiesRating") String careerOpportunitiesRating,
                             @JsonProperty("workLifeBalanceRating") String workLifeBalanceRating,
                             @JsonProperty("recommendToFriendRating") String recommendToFriendRating) {
        this.website = website;
        this.squareLogo = squareLogo;
        this.overallRating = overallRating;
        this.cultureAndValuesRating = cultureAndValuesRating;
        this.seniorLeadershipRating = seniorLeadershipRating;
        this.compensationAndBenefitsRating = compensationAndBenefitsRating;
        this.careerOpportunitiesRating = careerOpportunitiesRating;
        this.workLifeBalanceRating = workLifeBalanceRating;
        this.recommendToFriendRating = recommendToFriendRating;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSquareLogo() {
        return squareLogo;
    }

    public void setSquareLogo(String squareLogo) {
        this.squareLogo = squareLogo;
    }

    public String getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }

    public String getCultureAndValuesRating() {
        return cultureAndValuesRating;
    }

    public void setCultureAndValuesRating(String cultureAndValuesRating) {
        this.cultureAndValuesRating = cultureAndValuesRating;
    }

    public String getSeniorLeadershipRating() {
        return seniorLeadershipRating;
    }

    public void setSeniorLeadershipRating(String seniorLeadershipRating) {
        this.seniorLeadershipRating = seniorLeadershipRating;
    }

    public String getCompensationAndBenefitsRating() {
        return compensationAndBenefitsRating;
    }

    public void setCompensationAndBenefitsRating(String compensationAndBenefitsRating) {
        this.compensationAndBenefitsRating = compensationAndBenefitsRating;
    }

    public String getCareerOpportunitiesRating() {
        return careerOpportunitiesRating;
    }

    public void setCareerOpportunitiesRating(String careerOpportunitiesRating) {
        this.careerOpportunitiesRating = careerOpportunitiesRating;
    }

    public String getWorkLifeBalanceRating() {
        return workLifeBalanceRating;
    }

    public void setWorkLifeBalanceRating(String workLifeBalanceRating) {
        this.workLifeBalanceRating = workLifeBalanceRating;
    }

    public String getRecommendToFriendRating() {
        return recommendToFriendRating;
    }

    public void setRecommendToFriendRating(String recommendToFriendRating) {
        this.recommendToFriendRating = recommendToFriendRating;
    }
}
