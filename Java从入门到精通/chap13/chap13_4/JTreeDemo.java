package chap13_4;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class JTreeDemo implements ActionListener,TreeModelListener{

	public static void main(String[] args) {
		new JTreeDemo();
	}
	public JTreeDemo(){
		DefaultTreeModel model=new DefaultTreeModel(MakeRootTree());
		tree=new JTree(model);
		tree.setEditable(true);
		tree.addMouseListener(new MouseHandle());
		treeModel=(DefaultTreeModel)tree.getModel();
		treeModel.addTreeModelListener(this);
		JFrame frame=new JFrame("JTree应用演示");
		Container contentpane=frame.getContentPane();
		JScrollPane scrollPane=new JScrollPane(tree);
		contentpane.add(scrollPane,"Center");
		InitPanel();
		contentpane.add(panel,"South");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250,300);
		frame.setVisible(true);
	}
	
	public DefaultMutableTreeNode MakeRootTree(){
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode child1=new DefaultMutableTreeNode("第一层");
		DefaultMutableTreeNode child11=new DefaultMutableTreeNode("第二层");
		DefaultMutableTreeNode child111=new DefaultMutableTreeNode("第三层");
		root.add(child1);
		child1.add(child11);
		child11.add(child111);
		return root;
	}
	private void InitPanel() {
		panel=new JPanel();
		addSibling=new JButton("添元素");
		addChild=new JButton("添节点");
		delete=new JButton("删除点");
		addSibling.addActionListener(this);
		addChild.addActionListener(this);
		delete.addActionListener(this);
		panel.add(addSibling);
		panel.add(addChild);
		panel.add(delete);
	}
	public void actionPerformed(ActionEvent event) {
		DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		if(selectedNode==null)
			return;
		if(event.getSource().equals(delete)){
			if(selectedNode.getParent()!=null)
				treeModel.removeNodeFromParent(selectedNode);
			return;
		}
		DefaultMutableTreeNode newNode=new DefaultMutableTreeNode("New");
		if(event.getSource().equals(addSibling)){
			DefaultMutableTreeNode parent=(DefaultMutableTreeNode)selectedNode.getParent();
			if(parent!=null){
				int selectedIndex=parent.getIndex(selectedNode);
				treeModel.insertNodeInto(newNode, parent, selectedIndex+1);
			}
		}else if(event.getSource().equals(addChild)){
			treeModel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
		}
		TreeNode[] nodes=treeModel.getPathToRoot(newNode);
		TreePath path=new TreePath(nodes);
		tree.scrollPathToVisible(path);
	}
	@Override
	public void treeNodesChanged(TreeModelEvent event) {
		TreePath treePath=event.getTreePath();
		DefaultMutableTreeNode node=(DefaultMutableTreeNode)treePath.getLastPathComponent();
		try {
			int[] index=event.getChildIndices();
			node=(DefaultMutableTreeNode)node.getChildAt(index[0]);
		} catch (NullPointerException exc) {
			System.out.println(nodeName+"更改数据为："+(String)node.getUserObject());
		}
	}
	@Override
	public void treeNodesInserted(TreeModelEvent arg0) {
		System.out.println("插入节点");
	}

	@Override
	public void treeNodesRemoved(TreeModelEvent arg0) {
		System.out.println("删除节点");
	}

	@Override
	public void treeStructureChanged(TreeModelEvent arg0) {
		System.out.println("结构改变");
	}
	class MouseHandle extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			try{
				JTree tree=(JTree)e.getSource();
				int rowLocation=tree.getRowForLocation(e.getX(), e.getY());
				if(rowLocation<0)	return;
				TreePath treePath=tree.getPathForRow(rowLocation);
				TreeNode treeNode=(TreeNode)treePath.getLastPathComponent();
				nodeName=treeNode.toString();
			}catch(NullPointerException ne){
				ne.printStackTrace();
			}
		}
	}
	
	private JTree tree=null;
	private DefaultTreeModel treeModel=null;
	private JPanel panel;
	private String nodeName= null;
	private JButton addSibling;
	private JButton addChild;
	private JButton delete;
}
