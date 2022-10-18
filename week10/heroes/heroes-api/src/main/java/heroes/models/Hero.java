package heroes.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Hero {

    private int heroId;

    @NotNull(message = "super name is required")
    @NotBlank(message = "super name is required")
    private String superName;

    @NotNull(message = "real name is required")
    @NotBlank(message = "real name is required")
    private String realName;

    @Pattern(message = "image url must be a url",
            regexp = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()!@:%_\\+.~#?&\\/\\/=]*)")
    private String imageUrl;

    @NotNull(message = "powers are required")
    @Size(min = 1, message = "hero must have at least one power")
    private List<Power> powers = new ArrayList<>();

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Power> getPowers() {
        return new ArrayList<>(powers);
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }


}
