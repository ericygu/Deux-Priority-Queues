package com.company;
//Eric Tiancheng Gu

public class PriorityQueueLink {
    LinkNode root;
    PriorityQueueLink(){

    }

    PriorityQueueLink(LinkNode root){
        this.root = root;

    }

    public void insert(int value){
        LinkNode n = new LinkNode(value);
        insert(n);
    }

    public void insert(LinkNode n){
        if(this.root == null){
            this.root = n;
            return;
        }
        compare(n,this.root);
    }


    private void compare(LinkNode n, LinkNode source){
        if (n.value > source.value){
            int temp = source.value;
            source.value = n.value;
            n.value = temp;

            compare(n,source);
        }

        else {
            if(source.leftChild == null){
                source.leftChild = n;
                n.parent = source;

            } else if (source.rightChild == null){
                source.rightChild = n;
                n.parent = source;
            } else {
                if(source.rightChild.value > source.leftChild.value){
                    compare(n,source.rightChild);
                } else {
                    compare(n, source.leftChild);
                }
            }
        }
    }

    public int deleteMax(){
        int answer = findMax();
        LinkNode placeholder= this.root;
        while(placeholder.leftChild != null){
            placeholder = placeholder.leftChild;
        }
        int value = placeholder.value;

        if(placeholder == this.root){
            return answer;
        }


        if(placeholder.parent.rightChild ==null){
            placeholder.parent.leftChild = null;
        }

        else {
            placeholder.parent.leftChild = placeholder.parent.rightChild;
            placeholder.parent.rightChild = null;
        }

        this.root.value = value;
        placeholder = this.root;

        while(placeholder.leftChild !=null || placeholder.rightChild !=null){
            if(placeholder.leftChild == null){
                if(placeholder.value < placeholder.rightChild.value){
                    int newValue = placeholder.value;
                    placeholder.value = placeholder.rightChild.value;
                    placeholder.rightChild.value = newValue;
                    placeholder = placeholder.rightChild;
                } else {
                    break;
                }

            } else if(placeholder.rightChild == null){
                if(placeholder.value < placeholder.leftChild.value) {
                    int newValue = placeholder.value;
                    placeholder.value = placeholder.leftChild.value;
                    placeholder.leftChild.value = newValue;
                    placeholder = placeholder.leftChild;
                }

                else {
                    break;
                }

            } else if(placeholder.rightChild.value > placeholder.leftChild.value){
                if(placeholder.value < placeholder.rightChild.value){
                    int newValue = placeholder.value;
                    placeholder.value = placeholder.rightChild.value;
                    placeholder.rightChild.value = newValue;
                    placeholder = placeholder.rightChild;
                }

                else {
                    break;
                }

            } else {
                if(placeholder.value < placeholder.leftChild.value){
                    int newValue = placeholder.value;
                    placeholder.value = placeholder.leftChild.value;
                    placeholder.leftChild.value = newValue;
                    placeholder = placeholder.leftChild;
                }

                else {
                    break;
                }
            }
        }
        return answer;
    }

    public int findMax(){
        return this.root.value;
    }
}
