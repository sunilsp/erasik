/**
 * 
 */
package rasik;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import com.rasik.model.Itemtype;
import com.rasik.model.ItemtypeDao;
import com.rasik.service.RasikServiceImpl;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * @author sunilsp
 *
 */
//@RunWith(MockitoJUnitRunner.class) //Use this for plan Mockito
@RunWith(PowerMockRunner.class) 	 // Use this for PowerMock with Mockito
@PrepareForTest({Itemtype.class})
public class ItemTypesDaoTest { //extends RasikDaoTestBase {
	
	
	@InjectMocks
    private RasikServiceImpl rasikSvc;
	
	@Mock
	private ItemtypeDao itemTypeDao;
	
	@Test
	//@Transactional
	//@Rollback(true)
	public void add(){
		Itemtype itemType=new Itemtype("Junit Test", 12.0,null );
		rasikSvc.saveItemTypes(itemType);
		Mockito.verify(itemTypeDao).persist(itemType);
		
	}
	
	@Test
	public void fetch(){ 
		Itemtype itemType=new Itemtype("Junit Test", 12.0,null );
		when(itemTypeDao.findById(1)).thenReturn(itemType);
		Itemtype itemTypeReturned=rasikSvc.findItemTypeById(1);
		assertEquals(itemType,itemTypeReturned);
	}

	@Test
	public void update(){ 
		Itemtype itemType=mock(Itemtype.class);
		itemType.setDescription("Junit");
		itemType.setVatPerc(12.0);
		when(itemTypeDao.merge(itemType)).thenReturn(itemType);
		String result=rasikSvc.updateItemTypes(itemType);
		assertEquals("saved", result);
		verify(itemTypeDao).merge(itemType);
		verifyZeroInteractions( itemTypeDao );
        verifyNoMoreInteractions( itemTypeDao );
	}

}
