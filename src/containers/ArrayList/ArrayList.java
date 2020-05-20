package containers.ArrayList;

public class ArrayList<T>
{
	static final int s_SizeMultiplier = 2;
	private Object m_Elements[];
	private int m_OccupiedCount;

	public ArrayList()
	{
		m_Elements = new Object[0];
		m_OccupiedCount = 0;
	}

	public void add(T addition)
	{
		if(shouldExpand())
		{
			expand();
		}

		m_Elements[m_OccupiedCount] = addition;
		m_OccupiedCount++;
	}

	public T get(int index)
	{
		// Unchecked cast for best performance for now
		return (T)m_Elements[index];
	}

	public void set(int index, T item)
	{
		m_Elements[index] = item;
	}

	public String toString()
	{
		StringBuilder result = new StringBuilder(new String("[ "));

		for(int i = 0; i < m_OccupiedCount; i++)
		{
			result.append(m_Elements[i].toString()).append(" ");
		}

		result.append("]");

		return result.toString();
	}

	private boolean shouldExpand()
	{
		// -1 is required because m_OccupiedIndex is an index.
		// It is one below the total occupied elements.
		return m_OccupiedCount == m_Elements.length;
	}

	private void expand()
	{
		int newSize = m_Elements.length == 0 ? 1 : m_Elements.length * s_SizeMultiplier;

		Object newArray[] = new Object[newSize];

		for(int i = 0; i < m_Elements.length; i++)
		{
			newArray[i] = m_Elements[i];
		}

		m_Elements = newArray;
	}
}
