package mate.academy.boot.bootdemo.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserDto {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private LocalDateTime time;
    private String summary;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Long getHelpfulnessNumerator() {
        return helpfulnessNumerator;
    }

    public void setHelpfulnessNumerator(Long helpfulnessNumerator) {
        this.helpfulnessNumerator = helpfulnessNumerator;
    }

    public Long getHelpfulnessDenominator() {
        return helpfulnessDenominator;
    }

    public void setHelpfulnessDenominator(Long helpfulnessDenominator) {
        this.helpfulnessDenominator = helpfulnessDenominator;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id)
                && Objects.equals(productId, userDto.productId)
                && Objects.equals(userId, userDto.userId)
                && Objects.equals(profileName, userDto.profileName)
                && Objects.equals(helpfulnessNumerator, userDto.helpfulnessNumerator)
                && Objects.equals(helpfulnessDenominator, userDto.helpfulnessDenominator)
                && Objects.equals(score, userDto.score)
                && Objects.equals(time, userDto.time)
                && Objects.equals(summary, userDto.summary)
                && Objects.equals(text, userDto.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, userId,
                profileName, helpfulnessNumerator,
                helpfulnessDenominator, score, time, summary, text);
    }

    @Override
    public String toString() {
        return "UserDto{" + "id=" + id
                + ", productId=" + productId
                + ", userId=" + userId
                + ", profileName='" + profileName + '\''
                + ", helpfulnessNumerator=" + helpfulnessNumerator
                + ", helpfulnessDenominator=" + helpfulnessDenominator
                + ", score=" + score + ", time=" + time
                + ", summary='" + summary + '\''
                + ", text='" + text + '\'' + '}';
    }
}
