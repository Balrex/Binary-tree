public class BinaryTree {
    node head;
    int count=0;

    public BinaryTree(){
    }
    //добавление элемента
    public void AddEl(double data) {
        int marker = 1;
        node tmp_node = new node(data, null, null);
        if (head == null) {
            head=tmp_node;
            count++;
        } else {
            node new_node = new node(data, null, null);
            tmp_node=head;
            do {
                if (data < tmp_node.data && tmp_node.left != null)
                    tmp_node = tmp_node.left;
                else if (data > tmp_node.data && tmp_node.right != null)
                    tmp_node = tmp_node.right;
                else
                    marker = 0;
            } while (marker == 1);
            if (data < tmp_node.data)
                tmp_node.left = new_node;
            else if (data > tmp_node.data)
                tmp_node.right = new_node;
            count++;
        }
    }
    //поиск элемента
    public void FindEl(double data){
        int marker=1;
        node tmp_node=head;
        do{
            if (data < tmp_node.data && tmp_node.left != null)
                tmp_node = tmp_node.left;
            else if (data > tmp_node.data && tmp_node.right != null)
                tmp_node = tmp_node.right;
            else
                marker = 0;
        }while (marker==1);
        if (tmp_node.data==data)
            System.out.println("Число "+data+" есть в списке.");
        else
            System.out.println("Числа "+data+" нет в списке.");
    }
    //поиск максимального и минимального элементов
    public void MinMax(){
        int marker=1;
        double min=-1;
        node tmp_node=head;
        do {
                if (tmp_node.left!=null){
                    tmp_node=tmp_node.left;
                    min = tmp_node.data;
                }else
                    marker=0;
        }while (marker==1);
        System.out.println("Минимальный элемент в дереве: "+min);
        marker=1;
        tmp_node=head;
        double max=-1;
        do {
            if(tmp_node.right!=null){
                tmp_node=tmp_node.right;
                max = tmp_node.data;
            }else
                marker=0;
        }while (marker==1);
        System.out.println("Максимальный элемент в дереве: "+max);
    }
    //удаление всех элементов
    public void clear(){
        if (head==null)
            System.out.println("Сипсок и так уже псут");
        else if (head.left==null && head.right==null){
            head.data=0;
            head=null;
            count--;
            System.out.println("Список очищен");
        }else {
            do{
                node tmp1 = head;
                node tmp2=head;
                int marker=1;
                do {
                    if (tmp1.left!=null){
                        tmp2=tmp1;
                        tmp1=tmp1.left;
                    }else if (tmp1.right!=null){
                        tmp2=tmp1;
                        tmp1=tmp1.right;
                    }else
                        marker=0;
                }while (marker==1);
                if (tmp1.data < tmp2.data) {
                    tmp1.data = 0;
                    count--;
                    tmp2.left=null;
                }else{
                    tmp1.data=0;
                    count--;
                    tmp2.right=null;
                }
            }while (count!=0);
            head=null;
            System.out.println("Список очищен");
        }
    }
    public void Size(){
        System.out.println("Элементов в дереве: "+count);
    }
}
