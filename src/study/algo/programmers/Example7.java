package study.algo.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Example7 {
	public static void main(String[] args) {

		print(solution(new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } }));
	}

	/*
	 * ����Ʈ���� �����ϴ� ������ ��ǥ�� ��� �迭 nodeinfo�� �Ű������� �־��� ��, ����� ������ ����Ʈ���� ���� ��ȸ, ���� ��ȸ��
	 * ����� 2���� �迭�� ������� ��� return �ϵ��� solution �Լ��� �ϼ�����.
	 * 
	 * nodeinfo�� ����Ʈ���� �����ϴ� �� ����� ��ǥ�� 1�� ������ ������� ����ִ� 2���� �迭�̴�. nodeinfo�� ���̴� 1 �̻�
	 * 10,000 �����̴�. nodeinfo[i] �� i + 1�� ����� ��ǥ�̸�, [x�� ��ǥ, y�� ��ǥ] ������ ����ִ�. ��� �����
	 * ��ǥ ���� 0 �̻� 100,000 ������ �����̴�. Ʈ���� ���̰� 1,000 ������ ��츸 �Է����� �־�����. ��� ����� ��ǥ�� ������
	 * �־��� ��Ģ�� ������, �߸��� ��� ��ġ�� �־����� ���� ����.
	 * 
	 */
	public static int[][] solution(int[][] nodeinfo) {
		int answer[][] = {};
		int len = nodeinfo.length;

		// �־��� �迭�� ������ ������ ����Ʈ�� ���� & ��� �� ����
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (int i = 0; i < len; i++) {
			TreeNode node = new TreeNode(nodeinfo[i][0], nodeinfo[i][1], i + 1);
			nodes.add(node);
		}

		// ����Ʈ�� ������ ���� ��� ����(Y��ǥ �������� �� X��ǥ ��������)
		Collections.sort(nodes, (TreeNode o1, TreeNode o2) -> {
			return o1.getY() == o2.getY() ? Integer.compare(o1.getX(), o2.getX())
					: Integer.compare(o2.getY(), o1.getY());
		});

		// ����Ʈ�� ����
		TreeNode root = makeTree(nodes, 0, 100000);
		// ��� ���� �ʱ�ȭ
//		initTree(root);
		// ���� ��ȸ, ������ȸ
		answer =  new int[][] { preOrder(root, len), postOrder(root, len) };
		return answer;
	}

	/**
	 * Description : Ʈ�� ���� - �־��� TreeNode Ÿ�� ����Ʈ�� �����͸� �������� ���踦 �����Ͽ� Ʈ�� ����
	 * 
	 * @param nodelist Ʈ���� ������ ����Ʈ
	 * @param idx      �θ� ����� �ε��� ��
	 * @param prevX    �θ� ��� ���� X��ǥ �ִ� ��
	 * @return
	 */
	private static TreeNode makeTree(List<TreeNode> nodelist, int idx, int prevX) {
		TreeNode node = nodelist.get(idx); // ��帮��Ʈ���� ��� ������
		node.setVisited(true); // Ʈ�� ���� ���� true
		int nextY = node.getY(); // nextY ���� �� �ʱ�ȭ(���� ����� Y��)
		int nextIdx = idx; // nextIdx ���� �� �ʱ�ȭ(���� ����� �ε���)

		// ���� ��� ���� �ε��� ��ȸ�ϸ鼭 ���� ��忡 �ش��ϴ� Y�� ����
		for (int i = idx + 1; i < nodelist.size(); i++) {
			if (nodelist.get(idx).getY() > nodelist.get(i).getY()) {
				nextY = nodelist.get(i).getY();
				nextIdx = i;
				break;
			}
		}

		// ���� ������ �ε��� ��ȸ�ϸ鼭 �ڽ� ���(��, ��) ��������� ����
		for (int i = nextIdx; i < nodelist.size(); i++) {
			// Ʈ���� ���Ե��� ���� ��� �� ���� ��� Y��(������ ������ nextY)�� ���� ���
			if (!nodelist.get(i).isVisited() && nodelist.get(i).getY() == nextY) {
				// X ���� ���� ��庸�� �۰�, prevX���� ���� ��� left ��� ����
				if (nodelist.get(i).getX() < nodelist.get(idx).getX() && nodelist.get(i).getX() < prevX) {
					node.setLeft(makeTree(nodelist, i, node.getX()));
				}
				// X ���� ���� ��庸�� ũ��, prevX���� ���� ��� right ��� ����
				if (nodelist.get(i).getX() > nodelist.get(idx).getX() && nodelist.get(i).getX() < prevX) {
					node.setRight(makeTree(nodelist, i, prevX));
				}

				// ������ ��� ������ ��� �� �̻� ��ȸ���� ����
				if (node.getRight() != null) {
					break;
				}
			}
		}

		return node;
	}

	/**
	 * Description : ���� ������ visited �� false�� �ʱ�ȭ
	 * 
	 * @param node �ʱ�ȭ�� Ʈ���� ���
	 */
	private static void initTree(TreeNode node) {
		node.setVisited(false);
		if (node.getLeft() != null) {
			initTree(node.getLeft());
		}
		if (node.getRight() != null) {
			initTree(node.getRight());
		}
	}

	private static int[] preOrder(TreeNode root, int size) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int[] result = new int[size];
		int i = 0;

		while (result[size - 1] == 0) {
			result[i++] = root.getVal();
			if (root.getRight() != null) {
				stack.push(root.getRight());
			}
			if (root.getLeft() != null) {
				root = root.getLeft();
				continue;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
			}

			if (stack.isEmpty() && root.getLeft() != null && root.getRight() != null) {
				break;
			}
		}
		return result;
	}

	private static int[] postOrder(TreeNode root, int size) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int[] result = new int[size];
		int i = size;

		while (result[0] == 0) {
			result[--i] = root.getVal();
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
			}
			if (root.getRight() != null) {
				root = root.getRight();
			} else if (!stack.isEmpty()) {
				root = stack.pop();
			} else {
				break;
			}
		}
		return result;
	}

	public static void print(int[][] result) {
		System.out.print("[");
		boolean first_outer = true;
		for (int[] rarr : result) {
			boolean first = true;
			if (first_outer) {
				System.out.print("[");
				first_outer = false;
			} else {
				System.out.print(", [");
			}
			for (int r : rarr) {
				if (first) {
					System.out.print(r);
					first = false;
				} else {
					System.out.print(", " + r);
				}
			}
			System.out.print("]");
		}
		System.out.print("]");
		System.out.println();
	}

}

class TreeNode {
	private int X;
	private int Y;
	private int val;
	private boolean visited;

	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int X, int Y, int val) {
		this.X = X;
		this.Y = Y;
		this.val = val;
		visited = false;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}