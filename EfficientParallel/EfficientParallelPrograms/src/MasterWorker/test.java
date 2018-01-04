package MasterWorker;
import java.util.Map;
import java.util.Set;

/**
 * @author yhk
 * ����˼���ǣ�ϵͳ����������Э�鹤����Master���̺�Worker���̡�
 * Master���̸�����պͷ�������Worker���̸�����������
 * ������Worker���̽�����������󣬽�������ظ�Master���̣���Master���й��ɺͻ��ܣ��Ӷ��õ�ϵͳ�����
 */
public class test {

	public static void main(String[] args) {
		Master m=new Master(new RealWorker(), 5);
		for (int i = 0; i < 100; i++) {
			m.submit(i);
		}
		Long start = System.currentTimeMillis();
		m.execute();
		long re=0;
		Map<String, Object>resultMap= m.getResultMap();
		
		//�˴����������һ��ʱ�䣬���resultMap�Ķ�д�����ᷢ����ͻ�����³��������
		//ԭ��resultmap��û��д��Ϳ�ʼ��������
		//����취����resultmap��ΪConcurrentHashMap
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (!m.isComplete()) {
			System.out.println(resultMap.size());
//			Integer i=null;
//			if(key!=null) i=(Integer)resultMap.get(key);
//			if(i!=null) re+=i;
//			if(key!=null){
//				resultMap.remove(key);
//			}
//			if(resultMap.isEmpty()){
//				System.out.println(re);
//			}
		}
		Set<String>keys= resultMap.keySet();
		System.out.println("key count : "+keys.size());
//		String key= null;
		for(String k:keys){
//			key=k;
			re += (Integer)resultMap.get(k);
			System.out.println(k+":"+re);
		}
		Long stop= System.currentTimeMillis();
		System.out.println(stop-start);
	}

}
