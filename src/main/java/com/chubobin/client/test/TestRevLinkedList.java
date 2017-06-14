package com.chubobin.client.test;

import java.util.ArrayList;
import java.util.List;

class Node {
	private String key ;
	private Node nextNode;
	
	public Node(String key){
		this.key=key;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}

public class TestRevLinkedList {
	
	//循环方法
	public static Node revLinkedList(Node head){
		
		Node firstNode=head;
		Node secondNode=firstNode.getNextNode();
		firstNode.setNextNode(null);
		Node tmpNode=null;
		while(secondNode!=null){
			tmpNode=secondNode.getNextNode();
			secondNode.setNextNode(firstNode);
			firstNode=secondNode;
			secondNode=tmpNode;
		}
		return firstNode;
	}
	
	
	//递归方法
	public static Node revLinkedList2(Node head){
		
		if ( head.getNextNode()==null) {       //递归结束的条件
			return head;
		} else {
			
			    Node rehead= revLinkedList2(head.getNextNode())	;	// 参数的变化就是迭代的步长
				Node second= head.getNextNode();			//递归的操作
			    second.setNextNode(head);
			    head.setNextNode(null);
				return rehead;
		}
	}
	
	public static Node sortNode(Node head) { 
		List<Node> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.getNextNode();
		}
		list.get(0).setNextNode(null);
		int len = list.size() - 1;
		for (int i = len; i > 0; i--) {
			list.get(i).setNextNode(list.get(i - 1));
		}

		return list.get(len);
	}
	
	
	//学生完成  好评！
	public static Node sortNode2(Node node) {
		Node prev = null;
		Node next = null;
		while (node != null) {
			next = node.getNextNode();
			node.setNextNode(prev);
			prev = node;
			node = next;
		}
		return prev;
	}
	

	public static void main(String[] args) {
		Node head=new Node("A");
		Node node1=new Node("B");
		Node node2=new Node("C");
		Node node3=new Node("D");
		Node node4=new Node("E");
		head.setNextNode(node1);
		node1.setNextNode(node2);
		node2.setNextNode(node3);
		node3.setNextNode(node4);
		
		Node tmpNode=head;
		while(tmpNode!=null){
			System.out.println(tmpNode.getKey());
			tmpNode=tmpNode.getNextNode();
		}
		
		Node newHead=sortNode2(head);


	    tmpNode=newHead;
		while(tmpNode!=null){
			System.out.println(tmpNode.getKey());
			tmpNode =tmpNode.getNextNode();
		}

	}

}
