package com.camelcasing.image.gif;

public class OctreeNode{
	
		private int count = 0;
		private OctreeNode[] children = new OctreeNode[8];
		private OctreeNode parent;
		private int red, green, blue;
		private int index;
	
	public OctreeNode(OctreeNode parent, int index){
		this.parent = parent;
		this.index = index;
	}

	public OctreeNode addColor(int r, int g, int b, int count){
		this.count += count;
		red += r;
		green += g;
		blue += b;
		return this;
	}
	
	/**
	 * Adds RGB values to the node and increments the count by one
	 * @param r red value
	 * @param g green value
	 * @param b blue value
	 * @return
	 */
	public OctreeNode addColor(int r, int g, int b){
		addColor(r, g, b, 1);
		return this;
	}
	/**
	 * 
	 * @param index
	 * @return
	 * @throws NullPointerException if index is less than 0 or greater than 7
	 */
	public OctreeNode getChild(int index) throws NullPointerException{
			if(children[index] == null){
				children[index] = new OctreeNode(this, index);
			}
		return children[index];
	}

	/**
	 * 
	 * @param index of the child (0-7)
	 * @return Then Octree node for the given index or null if child does not exist
	 * @throws <code>IllegalArgumentException</code> if index outside expected range
	 */
	public OctreeNode getChildIfExists(int index) throws IllegalArgumentException{
			if(index < 0 || index > 7){
				throw new IllegalArgumentException("Index must be between 0 and 7");
			}
		return children[index];
	}
	
	public void mergeUp(){
		parent.addColor(red, green, blue, count);
		parent.kill(index);
	}
	
	protected void kill(int index){
		children[index] = null;
	}
	
	public OctreeNode getParent(){
		return parent;
	}
	
	public int getColorCount(){
		return count;
	}

	public int getRed() {
		return red / count;
	}

	public int getGreen() {
		return green / count;
	}

	public int getBlue() {
		return blue / count;
	}
	
	public int getIndex(){
		return index;
	}
	
	@Override
	public String toString(){
		return("OctreeNode, index = " + index + " count = " + count +
				" red = " + getRed() + " green = " + getGreen() + " blue = " + getBlue());
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blue;
		result = prime * result + count;
		result = prime * result + green;
		result = prime * result + index;
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + red;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OctreeNode other = (OctreeNode) obj;
		if (blue != other.blue)
			return false;
		if (count != other.count)
			return false;
		if (green != other.green)
			return false;
		if (index != other.index)
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (red != other.red)
			return false;
		return true;
	}

}