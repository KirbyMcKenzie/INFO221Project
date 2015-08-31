package dao;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * A collection class that manages one-to-many data. It has a similar interface
 * to java.util.Map.
 *
 * When you add a value to the collection you specify which category it belongs
 * to. You can then find all of the values for a given category.
 *
 * @author Mark
 *
 * @param <Category> The category.
 * @param <Value> The value.
 */
public class MultiMap<Category, Value> {

	private final Map<Category, Set<Value>> map = new TreeMap<>();

	/**
	 * Adds a value to the collection.
	 *
	 * @param category The category that the value is associated with.
	 * @param value The value.
	 */
	public void put(Category category, Value value) {

		if (map.containsKey(category)) {
			// category already exists so get the list and add value to it
			map.get(category).add(value);
		} else {
			// category doesn't exist yet so create list
			Set<Value> set = new TreeSet<>();

			// add the value to the list
			set.add(value);

			// and put list into the map
			map.put(category, set);
		}
	}

	/**
	 * Returns a list of values for a given category.
	 *
	 * @param category The category.
	 * @return A list of values that are associated with that category.
	 */
	public Collection<Value> get(Category category) {
		return map.get(category);
	}

	/**
	 * Returns true if the map contains the given category.
	 *
	 * @param category
	 * @return
	 */
	public boolean containsCategory(Category category) {
		return map.containsKey(category);
	}

	/**
	 * Returns the categories.
	 *
	 * @return
	 */
	public Set<Category> categories() {
		return map.keySet();
	}

	/**
	 * Removes a value from a category.
	 *
	 * @param category
	 * @param value
	 */
	public void remove(Category category, Value value) {
		map.get(category).remove(value);
	}

	/**
	 * Find the number of categories in the map.
	 *
	 * @return the number of categories
	 */
	public int size() {
		return map.size();
	}

	/**
	 * Find the number of elements in a given category.
	 *
	 * @param category the category to check the size of
	 * @return the number of categories
	 */
	public int sizeOfCategory(Category category) {
		return map.get(category).size();
	}

}
