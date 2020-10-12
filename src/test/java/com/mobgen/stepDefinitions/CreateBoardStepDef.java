package com.mobgen.stepDefinitions;

import com.mobgen.pages.Boards;
import com.mobgen.pages.Dashboard;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;

import java.util.List;

public class CreateBoardStepDef {

    Dashboard dashboard = new Dashboard();
    Boards boards = new Boards();

    @Given("click to Create New Board")
    public void click_to_create_new_board() throws InterruptedException {
        Thread.sleep(3000);
      dashboard.newBoard.click();
    }

    @Given("the user writes a board name {string}")
    public void the_user_writes_a_board_name(String boardName) {
       dashboard.addBoardTitle.sendKeys(boardName);
    }

    @Given("choose blue color")
    public void choose_blue_color() {
     dashboard.color.click();
    }

    @Given("the user click team visible")
    public void the_user_click_team_visible() {
        dashboard.visible.click();
    }


    @And("the select public")
    public void theSelectPublic() {
        dashboard.selectPublic.click();
    }

    @And("the user click make public")
    public void theUserClickMakePublic() {
        dashboard.makePublic.click();
    }

    @And("the user click createBoardButton")
    public void theUserClickCreateBoardButton() {
        dashboard.craeteBoardButton.click();
    }

    @And("the user enters the list following")
    public void theUserEntersTheListFollowing(List<String> list) {
       boards.name.sendKeys(list.get(0)+ Keys.ENTER);
       boards.name.sendKeys(list.get(1)+ Keys.ENTER);
       boards.name.sendKeys(list.get(2)+ Keys.ENTER);
       boards.name.sendKeys(list.get(3)+ Keys.ENTER);
       boards.name.sendKeys(list.get(4)+ Keys.ENTER);


    }
}
