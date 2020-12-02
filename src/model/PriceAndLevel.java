package model;
public interface PriceAndLevel{
	private double calculatePrice();
	private void updatePrice();
	public String getPrice();
	private double calculateLevel();
	private void updateLevel();
	public String getLevel();
}