package Product;

public class RewardSystem {  
    private static final int POINTS_PER_PURCHASE = 10; // 每次购买获得的积分  
    static final int POINTS_FOR_DISCOUNT = 100; // 换取折扣所需的积分  
    private static final int DISCOUNT_PERCENTAGE = 10; // 折扣百分比  
  
    // 假设这是获取当前顾客购买咖啡所应获得的积分的方法  
    public int getPointsForPurchase(double purchaseAmount) {  
        // 根据购买金额计算积分，这里简化处理，每次购买固定获得10积分  
        return (int) (purchaseAmount / 1) * POINTS_PER_PURCHASE;  
    }  
  
    // 检查顾客是否有足够的积分来换取折扣  
    public boolean hasEnoughPointsForDiscount(Customer customer) {  
        return customer.getPoints() >= POINTS_FOR_DISCOUNT;  
    }  
  
    // 应用折扣到购买金额  
    public double applyDiscount(double purchaseAmount) {  
        return purchaseAmount * (100 - DISCOUNT_PERCENTAGE) / 100;  
    }  
  
    // 提供其他与积分相关的业务逻辑...  
}
