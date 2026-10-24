package kuchma.mike.bbdm.application;

import kuchma.mike.bbdm.domain.model.GameId;
import kuchma.mike.bbdm.domain.model.ItemPurchaseResult;
import kuchma.mike.bbdm.domain.model.MessageBoard;
import kuchma.mike.bbdm.domain.model.MessageId;
import kuchma.mike.bbdm.domain.model.MessageResolution;
import kuchma.mike.bbdm.domain.model.ShopInventory;
import kuchma.mike.bbdm.domain.model.ShopItemId;
import kuchma.mike.bbdm.domain.model.StartedGame;
import kuchma.mike.bbdm.domain.port.GameGateway;

public class GameService {
    private final GameGateway gameGateway;

    public GameService(GameGateway gameGateway) {
        this.gameGateway = gameGateway;
    }

    public StartedGame startGame() {
        return gameGateway.startGame();
    }

    public MessageBoard getMessages(String gameId) {
        return gameGateway.getMessages(new GameId(gameId));
    }

    public MessageResolution dealWithMessage(String gameId, String messageId) {
        return gameGateway.dealWithMessage(new GameId(gameId), new MessageId(messageId));
    }

    public ShopInventory getShop(String gameId) {
        return gameGateway.getShop(new GameId(gameId));
    }

    public ItemPurchaseResult buyItem(String gameId, String itemId) {
        return gameGateway.buyItem(new GameId(gameId), new ShopItemId(itemId));
    }
}
