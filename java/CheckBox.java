/**
     *CheckBoxNodeRenderer.java
     */   

    public class CheckBoxNodeRenderer implements TreeCellRenderer{
public JCheckBox getLeafRenderer()
{
    return leafRenderer;
}
public CheckBoxNodeRenderer() 
{
    Font fontValue;
    fontValue = UIManager.getFont("Tree.font");
    if (fontValue != null) {
        leafRenderer.setFont(fontValue);
    }
    Boolean booleanValue = (Boolean) UIManager
    .get("Tree.drawsFocusBorderAroundIcon");
    leafRenderer.setFocusPainted((booleanValue != null)
            && (booleanValue.booleanValue()));
    selectionBorderColor = UIManager.getColor("Tree.selectionBorderColor");
    selectionForeground = UIManager.getColor("Tree.selectionForeground");
    selectionBackground = UIManager.getColor("Tree.selectionBackground");
    textForeground = UIManager.getColor("Tree.textForeground");
    textBackground = UIManager.getColor("Tree.textBackground");
}
public Component getTreeCellRendererComponent(JTree tree, Object value,
        boolean selected, boolean expanded, boolean leaf, int row,
        boolean hasFocus) 
{
    Component returnValue;
    if (leaf) {
        String stringValue = tree.convertValueToText(value, selected,
                expanded, leaf, row, false);
        if (selected) {
            leafRenderer.setForeground(selectionForeground);
            leafRenderer.setBackground(selectionBackground);
        } else {
            leafRenderer.setForeground(textForeground);
            leafRenderer.setBackground(textBackground);
        }
        if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
            Object userObject = ((DefaultMutableTreeNode) value)
            .getUserObject();
            if (userObject instanceof CheckBoxNode) {
                CheckBoxNode node = (CheckBoxNode) userObject;
                leafRenderer.setText(node.getText());
                leafRenderer.setSelected(node.isSelected());
            }
        }
        returnValue = leafRenderer;
    } else {

        leafRenderer.setText(value.toString());

        leafRenderer.setSelected(selected);
        returnValue = leafRenderer;

    }
    return returnValue;
}
public JCheckBox leafRenderer = new JCheckBox();
private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();
Color selectionBorderColor, selectionForeground, selectionBackground,
textForeground, textBackground;

}
