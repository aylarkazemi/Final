import java.util.*;
public class Category {
    private String name;
    private List<Category> subcategories;
    public Category(String name) {
        this.name = name;
        this.subcategories = new ArrayList<>(); }
    public void addSubcategory(Category category) {
        subcategories.add(category); }
    public void removeSubcategory(Category category) {
        subcategories.remove(category); }
    public String getName() {
        return name; }
    public List<Category> getSubcategories() {
        return subcategories;}
    @Override
    public String toString() {
        return "Category: " + name;
    }
}